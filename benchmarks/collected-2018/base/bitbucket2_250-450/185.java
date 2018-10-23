// https://searchcode.com/api/result/62834077/

//
// Copyright (C) 2008 United States Government as represented by the
// Administrator of the National Aeronautics and Space Administration
// (NASA).  All Rights Reserved.
//
// This software is distributed under the NASA Open Source Agreement
// (NOSA), version 1.3.  The NOSA has been approved by the Open Source
// Initiative.  See the file NOSA-1.3-JPF at the top of the distribution
// directory tree for the complete NOSA document.
//
// THE SUBJECT SOFTWARE IS PROVIDED "AS IS" WITHOUT ANY WARRANTY OF ANY
// KIND, EITHER EXPRESSED, IMPLIED, OR STATUTORY, INCLUDING, BUT NOT
// LIMITED TO, ANY WARRANTY THAT THE SUBJECT SOFTWARE WILL CONFORM TO
// SPECIFICATIONS, ANY IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR
// A PARTICULAR PURPOSE, OR FREEDOM FROM INFRINGEMENT, ANY WARRANTY THAT
// THE SUBJECT SOFTWARE WILL BE ERROR FREE, OR ANY WARRANTY THAT
// DOCUMENTATION, IF PROVIDED, WILL CONFORM TO THE SUBJECT SOFTWARE.
//
package gov.nasa.jpf.jvm;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;

import java.util.List;
import java.util.logging.Logger;

/**
 * a FieldLockInfo implementation with the following strategy:
 * 
 *   - at each check, store the intersection of the current threads lock set
 *     with the previous field lock set
 *   - if the access was checked less than CHECK_THRESHOLD times, report the
 *     field as unprotected
 *   - if the field lock set doesn't become empty after CHECK_THRESHOLD, report
 *     the field as protected
 *   - as an optimization, raise the check level above the threshold if we
 *     have a good probability that a current lock is a protection lock for this
 *     field
 *   - continue to check even after reaching the threshold, so that we
 *     can at least report a violated assumption
 *     
 *  NOTE there is a subtle problem: if we ever falsely assume lock protection
 *  in a path that subsequently recycles the shared object (e.g. by leading
 *  into an end state), we loose the assumption. If this is followed by
 *  a backtrack and execution of a path that uses a conflicting assumption
 *  (different or no lock), we will NOT detect potential races unless
 *  vm.por.sync_detection.pindown is set (which has some runtime costs)
 */

public class StatisticFieldLockInfoFactory implements FieldLockInfoFactory {

  static Logger log = JPF.getLogger("gov.nasa.jpf.jvm.FieldLockInfo");
  
  /**
   * the number of checks after which we decide if a non-empty lock set
   * means this field is protected
   */
  static int CHECK_THRESHOLD = 5;
  
  /**
   * do we want objects with final field lock assumptions to be pinned
   * down (not garbage collected), to make sure we don't loose these
   * assumptions and subsequently fail to detect an assumption violation
   * after backtracking (see above)
   */
  static boolean PINDOWN = false;

  /**
   * do we look for strong locking candidates (i.e. assume protection
   * if there is a lock related to the object).
   * NOTE this can lead to undetected race conditions if the assumption
   * subsequently fails
   */
  static boolean AGRESSIVE = false;
  
  
  public StatisticFieldLockInfoFactory (Config conf) {
    CHECK_THRESHOLD = conf.getInt("vm.por.sync_detection.threshold", CHECK_THRESHOLD);
    PINDOWN = conf.getBoolean("vm.por.sync_detection.pindown", PINDOWN);
    AGRESSIVE = conf.getBoolean("vm.por.sync_detection.agressive",AGRESSIVE);    
  }
  
  public FieldLockInfo createFieldLockInfo (ThreadInfo ti, ElementInfo ei, FieldInfo fi) {
    List<ElementInfo> currentLocks = ti.getLockedObjects();
    int n = currentLocks.size();

    if (n == 0) {
      return FieldLockInfo.empty; // not protected, never will
      
    } else {
      
      if (AGRESSIVE) {
        ElementInfo eiLockCandidate = strongProtectionCandidate(ei,fi,currentLocks);
        if (eiLockCandidate != null) {
          // NOTE we raise the checklevel
          return new SingleLockFli( ti, eiLockCandidate.getObjectRef(), CHECK_THRESHOLD);
        }
      }
      
      if (n == 1) { // most common case
        return new SingleLockFli( ti, currentLocks.get(0).getObjectRef(), 0);
      
      } else {
        return new MultiLockFli( ti, fi, currentLocks);
      }
    }
  }

  /**
   * check if the current thread lockset contains a lock with a high probability
   * that it is a protection lock for this field. We need this to avoid
   * state explosion due to the number of fields to check. Note that we don't
   * necessarily have to answer/decide which one is the best match in case of
   * several candidates (if we don't use this to reduce to StatisticFieldLockInfo1)
   *
   * For instance fields, this would be a lock with a distance <= 1.
   * For static fields, the corresponding class object is a good candidate.
   */
  ElementInfo strongProtectionCandidate (ElementInfo ei, FieldInfo fi, List<ElementInfo> currentLocks) {
    int n = currentLocks.size();

    if (fi.isStatic()) { // static field, check for class object locking
      ClassInfo ci = fi.getClassInfo();
      int cref = ci.getClassObjectRef();

      for (int i=0; i<n; i++) {
        ElementInfo e = currentLocks.get(i); // the locked object
        if (e.getObjectRef() == cref) {
          log.info("sync-detection: " + ei + " assumed to be synced on class object: " + e);
          return e;
        }
      }

    } else { // instance field, use lock distance as a heuristic
      for (int i=0; i<n; i++) {
        ElementInfo e = currentLocks.get(i); // the locked object
        int eidx = e.getObjectRef();

        // case 1: synchronization on field owner itself
        if (ei == e) {
          log.info("sync-detection: " + ei + " assumed to be synced on itself");
          return e;
        }

        // case 2: synchronization on owner of object holding field (sync wrapper)
        if (e.hasRefField(ei.getObjectRef())) {
          log.info("sync-detection: " + ei + " assumed to be synced on object wrapper: " + e);
          return e;
        }

        // case 3: synchronization on sibling field that is a private lock object
        if (ei.hasRefField(eidx)) {
          log.info("sync-detection: "+ ei + " assumed to be synced on sibling: " + e);
          return e;
        }
      }
    }

    return null;
  }

  
  
  //--- root for our concrete FieldLockInfo classes
  static abstract class StatisticFieldLockInfo extends FieldLockInfo {
    int checkLevel;

    public boolean isProtected () {
      return (checkLevel >= CHECK_THRESHOLD);
    }

    public boolean needsPindown (ElementInfo ei) {
      return PINDOWN && (checkLevel >= CHECK_THRESHOLD);
    }

    protected void checkFailedLockAssumption(ThreadInfo ti, ElementInfo ei, FieldInfo fi) {
      if (checkLevel >= CHECK_THRESHOLD) {
        lockAssumptionFailed(ti,ei,fi);
      }
    }
  }
  
  //--- Fli for a single lock
  static class SingleLockFli extends StatisticFieldLockInfo {
    int lockRef;
    
    SingleLockFli (ThreadInfo ti, int lockRef, int nChecks) {
      tiLastCheck = ti;

      this.lockRef = lockRef;
      checkLevel = nChecks;
    }

    protected int[] getCandidateLockSet() {
      int[] set = { lockRef };
      return set;
    }
    

    public FieldLockInfo checkProtection (ThreadInfo ti, ElementInfo ei, FieldInfo fi) {
      List<ElementInfo> currentLocks = ti.getLockedObjects();
      int n = currentLocks.size();
      
      checkLevel++;
      
      for (int i=0; i<n; i++) {
        ElementInfo lei = currentLocks.get(i);
        if (lei.getObjectRef() == lockRef) {
          return this;
        }
      }
      
      checkFailedLockAssumption(ti, ei, fi);
      return empty;
    }

    /**
     * only called at the end of the gc on all live objects. The recycled ones
     * are either already nulled in the heap, or are not marked as live
     */
    public FieldLockInfo cleanUp (Heap heap) {
      ElementInfo ei = heap.get(lockRef);
      if (!heap.isAlive(ei)) {
        return FieldLockInfo.empty;
      } else {
        return this;
      }
    }

    public String toString() {
      return ("SingleLockFli {checkLevel="+checkLevel+",lock="+lockRef + '}');
    }  
  }
  
  
  //--- StatisticFieldLockInfo for lock sets
  static class MultiLockFli extends StatisticFieldLockInfo {

    int[] lockRefSet;
      
    // this is only used once during prototype generation
    public MultiLockFli (ThreadInfo ti, FieldInfo fi, List<ElementInfo> currentLocks) {
      int n = currentLocks.size();
      lockRefSet = new int[n];
      
      for (int i=0; i<n; i++) {
        lockRefSet[i] = currentLocks.get(i).getObjectRef();
      }
    }
    
    protected int[] getCandidateLockSet() {
      return lockRefSet;
    }
      

    public FieldLockInfo checkProtection (ThreadInfo ti, ElementInfo ei, FieldInfo fi) {
      List<ElementInfo> currentLocks = ti.getLockedObjects();
      int nLocks = currentLocks.size();
          
      checkLevel++;

      if (nLocks == 0) { // no current locks, so intersection is empty
        checkFailedLockAssumption(ti, ei, fi);
        return empty;

      } else { // we had a lock set, and there currently is at least one lock held
        int l =0;
        int[] newLset = new int[lockRefSet.length];

        for (int i=0; i<nLocks; i++) { // get the set intersection
          ElementInfo lei = currentLocks.get(i);
          int leidx = lei.getObjectRef();

          for (int j=0; j<lockRefSet.length; j++) {
            if (lockRefSet[j] == leidx) {
              newLset[l++] = leidx;
              break; // sets don't contain duplicates
            }
          }
        }

        if (l == 0) { // intersection empty
          checkFailedLockAssumption(ti, ei, fi);
          return empty;
          
        } else if (l == 1) { // only one candidate left 
          return new SingleLockFli( ti, newLset[0], checkLevel);
        
        } else if (l < newLset.length) { // candidate set did shrink
          lockRefSet = new int[l];
          System.arraycopy(newLset, 0, lockRefSet, 0, l);
          
        } else {
          // no change
        }
      }

      tiLastCheck = ti;
      return this;
    }

    /**
     * only called at the end of the gc on all live objects. The recycled ones
     * are either already nulled in the heap, or are not marked as live
     */
    public FieldLockInfo cleanUp (Heap heap) {
      int[] newSet = null;
      int l = 0;

      if (lockRefSet != null) {
        for (int i=0; i<lockRefSet.length; i++) {
          ElementInfo ei = heap.get(lockRefSet[i]);

          if (!heap.isAlive(ei)) { // we got a stale one, so we have to change us
            if (newSet == null) { // first one, copy everything up to it
              newSet = new int[lockRefSet.length-1];
              if (i > 0) {
                System.arraycopy(lockRefSet, 0, newSet, 0, i);
                l = i;
              }
            }

          } else {
            if (newSet != null) { // we already had a dangling ref, now copy the live ones
              newSet[l++] = lockRefSet[i];
            }
          }
        }
      }

      if (l == 1) {
          assert (newSet != null);
          return new SingleLockFli(tiLastCheck, newSet[0], checkLevel);
          
      } else {
        if (newSet != null) {
          if (l == newSet.length) { // we just had one stale ref
            lockRefSet = newSet;
          } else { // several stales - make a new copy
            if (l == 0) {
              return empty;
            } else {
              lockRefSet = new int[l];
              System.arraycopy(newSet, 0, lockRefSet, 0, l);
            }
          }
        }
        return this;
      }
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("MultiLockFli {");
      sb.append("checkLevel=");
      sb.append(checkLevel);
      sb.append(",lset=[");
      if (lockRefSet != null) {
        for (int i=0; i<lockRefSet.length; i++) {
          if (i>0) {
            sb.append(',');
          }
          sb.append(lockRefSet[i]);
        }
      }
      sb.append("]}");

      return sb.toString();
    }
  }  
}

