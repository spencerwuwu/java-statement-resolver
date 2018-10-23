// https://searchcode.com/api/result/69649437/

package ncsa.d2k.modules.core.discovery.ruleassociation.apriori;

import java.io.*;
import java.util.*;
import ncsa.d2k.core.modules.*;
import ncsa.d2k.modules.core.discovery.ruleassociation.*;
import java.beans.PropertyVetoException;

/**
 Apriori.java
 */
public class Apriori extends ncsa.d2k.core.modules.ComputeModule {

	/** the names of the various items. */
	String[] nameList;

	/** the number of valid rules obtained.*/
	int validRules;

	/** this is the number of sets that must contain a given rule for it to
	 meet the support. */
	int cutoff;

	/** this is a list of results. */
	ArrayList results;

	/** this is an integer representation of the sets, each mutable integer array contains
	 *  a list of the items that set contains. */
	MutableIntegerArray[] documentMap = null;

	/** minimum support, expressed as a percentage. */
	double support = 20.0;

	/** start time. */
	long startTime;

	/**
	 Start a timer when we begin execution.
	 */
	public void beginExecution() {
		startTime = System.currentTimeMillis();
		results = new ArrayList();
	}

	public void endExecution() {
		super.endExecution();
		if (showProgress || debug) {
			System.out.println(
				getAlias()
					+ ": Total Elapsed Wallclock Time was "
					+ (System.currentTimeMillis() - startTime) / 1000.0
					+ " Seconds");
		}
		results = null;
		nameList = null;
		documentMap = null;
		sNames = null;
		currentItemsFlags = null;
		validRules = 0;
		targetIndices = null;
		nameAry = null;
	}

	/**
	 * Return the human readable name of the module.
	 * @return the human readable name of the module.
	 */
	public String getModuleName() {
		return "Apriori";
	}

	/**
	 This method returns the description of the module.
	 @return the description of the module.
	 */
	public String getModuleInfo() {
		StringBuffer sb = new StringBuffer("<p>Overview: ");
		sb.append(
			"This module implements the Apriori algorithm to generate frequent itemsets consisting of ");
		sb.append(
			"items that occur in a sufficient number of examples to satisfy the minimum support criteria. ");

		sb.append("</p><p>Detailed Description: ");
		sb.append(
			"This module takes an <i>Item Sets</i> object that has been generated by a <i>Table To Item Sets</i> ");
		sb.append("module and uses the Apriori algorithm to find ");
		sb.append(
			"the combinations of items that satisfy a minimum support criteria. ");
		sb.append(
			"An item is an [attribute,value] pair that occurs in the set of examples being mined. ");
		sb.append(
			"The user controls the support criteria via the <i>Minimum Support %</i> property that specifies the ");
		sb.append(
			"percentage of all examples that must contain a given combination of items ");
		sb.append(
			"before that combination is included in the generated output. ");
		sb.append(
			"Each combination of items that satisfies the <i>Minimum Support %</i> is called ");
		sb.append("a <i>Frequent Itemset</i>. ");

		sb.append("</p><p> ");
		sb.append(
			"The user can restrict the maximum number of items included in any frequent itemset with ");
		sb.append(
			"the <i>Maximum Items Per Rule</i> property.  The generation of sets with large number of items ");
		sb.append(
			"can be computationally expensive, so setting this property in conjunction with the <i>Minimum Support %</i> ");
		sb.append("property helps keep the module runtime reasonable. ");

		sb.append("</p><p>");
		sb.append(
			"In a typical itinerary the <i>Frequent Item Sets</i> output port from this module is connected to ");
		sb.append("a <i>Compute Confidence</i> module which forms ");
		sb.append(
			"association rules that satisfy a minimum confidence value. ");

		sb.append("</p><p>References: ");
		sb.append(
			"For more information on the Apriori rule association algorithm, see &quot;Fast Algorithms for Mining ");
		sb.append("Association Rules&quot;, Agrawal et al., 1994. ");

		sb.append("</p><p>Limitations: ");
		sb.append(
			"The <i>Apriori</i> and <i>Compute Confidence</i> modules currently ");
		sb.append("build rules with a single item in the consequent.  ");

		sb.append("</p><p>Data Type Restrictions: ");
		sb.append(
			"While this module can operate on attributes of any datatype, in practice it is usually infeasible ");
		sb.append(
			"to use it with continuous-valued attributes.   The module considers each [attribute,value] pair that occurs ");
		sb.append(
			"in the examples individually when building the frequent itemsets.  Continuous attributes (and categorical ");
		sb.append(
			"attributes with a large number of values) are less likely to meet the Minimum Support requirements ");
		sb.append(
			"and can result in unacceptably long execution time.  Typically <i>Choose Attributes</i> and <i>Binning</i> ");
		sb.append(
			"modules should appear in the itinerary prior to the <i>Table to Item Sets</i> module, whose output produces ");
		sb.append(
			"the <i>Item Sets</i> object used as input by this module.   The Choosing/Binning modules can reduce the ");
		sb.append(
			"number of distinct [attribute,value] pairs that must be considered in this module to a reasonable number. ");

		sb.append("</p><p>Data Handling: ");
		sb.append(
			"This module does not modify the input Item Sets in any way. ");

		sb.append("</p><p>Scalability: ");
		sb.append(
			"This module creates an array of integers to hold the indices of the items in each frequent itemset. ");
		sb.append(
			"The module may be computationally intensive, and scales with the number of Item Sets entries to search and the ");
		sb.append(
			"size of the frequent itemsets. The user can limit the size of the frequent itemsets and influence ");
		sb.append(
			"the number generated via the properties editor. Choosing and Binning modules can be included in the itinerary ");
		sb.append(
			"prior to this modules to reduce the number of Item Sets entries.  </p>");
		return sb.toString();
	}

	/**
	 * Return the human readable name of the indexed input.
	 * @param index the index of the input.
	 * @return the human readable name of the indexed input.
	 */
	public String getInputName(int index) {
		switch (index) {
			case 0 :
				return "Item Sets";
			default :
				return "No such input.";
		}
	}

	/**
	 This method returns the description of the various inputs.
	 @return the description of the indexed input.
	 */
	public String getInputInfo(int index) {
		switch (index) {
			case 0 :
				return "An object produced by a <i>Table To Item Sets</i> module "
					+ "containing items that will appear in the frequent itemsets. ";
			default :
				return "No such input";
		}
	}

	/**
	 This method returns an array of strings that contains the data types for the inputs.
	 @return the data types of all inputs.
	 */
	public String[] getInputTypes() {
		String[] types =
			{ "ncsa.d2k.modules.core.discovery.ruleassociation.ItemSets" };
		return types;
	}

	/**
	 * Return the human readable name of the indexed output.
	 * @param index the index of the output.
	 * @return the human readable name of the indexed output.
	 */
	public String getOutputName(int index) {
		switch (index) {
			case 0 :
				return "Frequent Itemsets";
			default :
				return "No such output.";
		}
	}

	/**
	 This method returns the description of the outputs.
	 @return the description of the indexed output.
	 */
	public String getOutputInfo(int index) {
		switch (index) {
			case 0 :
				String s =
					"A representation of the frequent itemsets found by the module. "
						+ "This representation encodes the items used in the sets "
						+ "and the number of examples in which each set occurs. This output is typically "
						+ "connected to a <i>Compute Confidence</i> module.";
				return s;
			default :
				return "No such output";
		}
	}

	/**
	 This method returns an array of strings that contains the data types for the outputs.
	 @return the data types of all outputs.
	 */
	public String[] getOutputTypes() {
		String[] types = { "[[I" };
		return types;
	}

	/** this property is the min acceptable support, expressed as a percentage. */
	public void setMinimumSupport(double d) throws PropertyVetoException {
		if (d <= 0.0 || 100.0 < d) {
			throw new PropertyVetoException(
				" Minimum Support % must be greater than 0 and less than or equal to 100.",
				null);
		}
		this.support = d;
	}

	public double getMinimumSupport() {
		return this.support;
	}

	/**
	 * the maximum number of attributes that will be included in any rule
	 */
	private int maxSize = 6;
	public void setMaxRuleSize(int yy) throws PropertyVetoException {
		if (yy < 2) {
			throw new PropertyVetoException(
				" Maximum Items per Rule cannot be less than 2.",
				null);
		}
		maxSize = yy;
	}

	public int getMaxRuleSize() {
		return this.maxSize;
	}

	/**
	 * the showProgress property.
	 */
	private boolean showProgress = true;
	public void setShowProgress(boolean yy) {
		this.showProgress = yy;
	}

	public boolean getShowProgress() {
		return this.showProgress;
	}

	/**
	 * the Debug property.
	 */
	private boolean debug = false;
	public void setDebug(boolean yy) {
		this.debug = yy;
	}

	public boolean getDebug() {
		return this.debug;
	}

	/**
	 * Return a list of the property descriptions.
	 * @return a list of the property descriptions.
	 */
	public PropertyDescription[] getPropertiesDescriptions() {
		PropertyDescription[] pds = new PropertyDescription[4];
		pds[0] =
			new PropertyDescription(
				"minimumSupport",
				"Minimum Support %",
				"The percent of all examples that must contain a given set of items "
					+ "before an association rule will be formed containing those items. "
					+ "This value must be greater than 0 and less than or equal to 100.");
		pds[1] =
			new PropertyDescription(
				"maxRuleSize",
				"Maximum Items per Rule",
				"The maximum number of items to include in any rule. "
					+ "This value cannot be less than 2.");
		pds[2] =
			new PropertyDescription(
				"showProgress",
				"Report Module Progress",
				"If this property is true, the module will report progress information to the console.");
		pds[3] =
			new PropertyDescription(
				"debug",
				"Generate Verbose Output",
				"If this property is true, the module will write verbose status information to the console.");
		return pds;
	}

	/**
	 Convert an array of flags that indicate the presence of an item
	 in the set to a list of the indices of the indexes of items present.
	 @param flags the boolean array containing a flag for each item, present or not present.
	 @param indices will contain an array of the indices of the items there.
	 */
	private int[] convertFlagsToIndices(boolean[] flags) {
		int[] tmp = new int[flags.length];
		int counter = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i]) {
				tmp[counter++] = i;
			}
		}
		if (counter == 0) {
			return null;
		}
		int indices[] = new int[counter];
		System.arraycopy(tmp, 0, indices, 0, counter);
		return indices;
	}

	/**
	 * These are the rules we have stored.
	 */
	class LocalResultSet implements Serializable {
		int[] set;
		MutableIntegerArray mia;
		LocalResultSet(int[] too, MutableIntegerArray mia) {
			this.set = too;
			this.mia = mia;
		}
	}

	/**
	 This is a hashable object containing an integer array.
	 */
	class FastHashIntArray implements Serializable {
		int[] toto;
		int hash;
		/**
		 take an array of integers.
		 */
		FastHashIntArray(int[] ints) {
			toto = ints;
			hash = (int) this.fastHash(ints);
		}

		FastHashIntArray() {
		}

		/**
		 This method computes the hashcode. The hashcode computation
		 here sucks.
		 */
		final int fastHash(int[] ints) {
			long thash = 0;
			for (int i = 0; i < ints.length; i++) {
				thash += ints[i];
			}
			return (int) thash / ints.length;
		}

		/**
		 Given a new array of intergers, set the local
		 array and compute a new hashcode.
		 @param ints the new integer array.
		 */
		final void setIntegers(int[] ints) {
			toto = ints;
			hash = fastHash(ints);
		}

		/**
		 Return a reference to a hashcode.
		 */
		final public int hashCode() {
			return hash;
		}

		/**
		 Compare each entry if necessary.
		 */
		final public boolean equals(Object obj) {
			FastHashIntArray fh = (FastHashIntArray) obj;
			if (fh.toto.length != this.toto.length) {
				return false;
			}

			for (int i = 0; i < toto.length; i++) {
				if (toto[i] != fh.toto[i]) {
					return false;
				}
			}

			return true;
		}

	}

	/**
	 Compute all the rules with the given cardinality (size). To do this, we
	 will take all the rules already generated of size cardinality-1, and add
	 each of the items which remain in our list of valid items to them to get
	 all the rules of size cardinality. For example, say the previous round
	 generated the following rules:
	 <OL>
	 <LI>1,3,6
	 <LI>1,2,3
	 <LI>2,3,6
	 </OL>
	 So the items that are still valid will be {1, 2, 3, 6}. So we will
	 derive the rules of size 4 from all the rules of size 3 by adding each
	 item from our list to each of the rules above where the rule does not
	 already contain that item. So, from the rules of three, here are our rules
	 of 4:
	 <ol>
	 <li>1,2,3,6
	 <li>1,2,3,6
	 <li>1,2,3,6
	 </ol>
	 Then, we eliminate the redundancies, and in fact in this case we end up
	 with only one rule.
	 @param items is the list of items.
	 @param cardinality the size of the resulting sets.
	 @returns all the possible rules of the given cardinality.
	 */
	private int[][] generatePossibleRules(int[] items, int cardinality) {

		int numItems = items.length;
		if (numItems < cardinality) {
			return null;
		}

		// Compute the number of rules we will need to generate.
		// This will be equal to the number of distinct sets generated
		// last time * the number of items available to choose from less
		// the number we already have. I think.
		int numSets =
			(results.size() - validRules) * (numItems - (cardinality - 1));
		FastHashIntArray fhia = new FastHashIntArray();

		//Allocate space for the rules
		int[][] rules = new int[numSets][];

		// Now generate each rule
		int[] rulebuffer = new int[cardinality - 1];
		int ruleCount = 0;
		HashMap dups = new HashMap();
		int oldSize = results.size(); // Since the list will grow.
		if (debug) {
			System.out.println("Apriori -> Valid Sets Possible : " + numSets);

			// We construct new rules from existing rules of size (cardinality-1).
		}
		MutableIntegerArray tmp = new MutableIntegerArray(numExamples);
		for (int i = validRules; i < oldSize; i++) {

			// Get the next rule of size cardinality-1, copy into the rule buffer.
			LocalResultSet lrs = (LocalResultSet) results.get(i);
			System.arraycopy(lrs.set, 0, rulebuffer, 0, cardinality - 1);
			MutableIntegerArray mia = lrs.mia;

			// Add each item we have to the current rule
			nextrule : for (
				int ruleIndex = 0, itemIndex = 0;
					itemIndex < items.length;
					itemIndex++) {

				// Find the first item in the rule not less than current item.
				while (ruleIndex < rulebuffer.length - 1
					&& rulebuffer[ruleIndex] < items[itemIndex]) {
					ruleIndex++;

				}
				if (rulebuffer[ruleIndex] != items[itemIndex]) {
					if (cardinality == 2) {

						// After we have all the rules of size two, we will know that each rule
						// will have at least one output item included, because the rules from
						// which we construct new rules will all contain a target.
						// Here we make sure we ignore any rule that does not contain an output.
						int targetIndex;
						if (targetIndices != null) {
							for (targetIndex = 0;
								targetIndex < targetIndices.length;
								targetIndex++) {
								if (rulebuffer[ruleIndex]
									== targetIndices[targetIndex]) {
									break;
								}
							}
							if (targetIndex >= targetIndices.length) {
								for (targetIndex = 0;
									targetIndex < targetIndices.length;
									targetIndex++) {
									if (items[itemIndex]
										== targetIndices[targetIndex]) {
										break;
									}
								}
							}
						}
					}

					// Find the number of examples that demonstrate the current rule and the new item.
					tmp.count = 0;
					mia.intersection(documentMap[items[itemIndex]], tmp);
					if (tmp.count >= cutoff) {

						// meet the support criterion, we have a new rule
						int[] newRule = new int[cardinality + 1];
						if (rulebuffer[ruleIndex] < items[itemIndex]) {

							// the new item should be added at the end.
							System.arraycopy(
								rulebuffer,
								0,
								newRule,
								0,
								ruleIndex + 1);
							newRule[ruleIndex + 1] = items[itemIndex];
						} else {
							System.arraycopy(
								rulebuffer,
								0,
								newRule,
								0,
								ruleIndex);
							newRule[ruleIndex] = items[itemIndex];
							System.arraycopy(
								rulebuffer,
								ruleIndex,
								newRule,
								ruleIndex + 1,
								rulebuffer.length - ruleIndex);
						}
						// we include the count and not the support because this is an array of ints and
						// we can't represent the support accurately enough.
						newRule[cardinality] = tmp.count;

						// We found one, is it a dup?
						fhia.setIntegers(newRule);
						Object nos = (Object) dups.get(fhia);
						if (nos == null) {

							// We have a valid rule.
							rules[ruleCount] = newRule;

							// Need a new rule buffer;
							FastHashIntArray darn =
								new FastHashIntArray(newRule);
							dups.put(darn, darn);
							results.add(
								new LocalResultSet(
									rules[ruleCount],
									new MutableIntegerArray(tmp)));
							rules[ruleCount] = newRule;
						} else {
							rules[ruleCount] = null;
						}
					} else {
						rules[ruleCount] = null;
					}
					ruleCount++;
				}
			}
			lrs.mia = null;
		}
		if (showProgress || debug) {
			int newSets = results.size() - oldSize;
			System.out.println(
				getAlias()
					+ ": Identified "
					+ newSets
					+ " frequent itemsets with "
					+ cardinality
					+ " items that met the support criteria.");
		}
		return rules;
	}

	/**
	 * Return true if either we still have input, or have more work to do.
	 * @return
	 */
	public boolean isReady() {
		if ((this.getFlags()[0] > 0) || !done) {
			return true;
		}
		return false;
	}

	/**
	 * Called when we are all done, it will construct the rules, and
	 * if there are any, pass them along.
	 */
	final private void finish() throws Exception {
		done = true;
		int[][] finalRules = null;
		int finalRuleCount = 0;
		for (int i = 0; i < results.size(); i++) {
			int[] tmp = ((LocalResultSet) results.get(i)).set;
			if (finalRules == null) {
				if (tmp.length > 1) {
					finalRules = new int[results.size() - i][];
				} else {
					continue;
				}
			}
			finalRules[finalRuleCount++] = tmp;
		}

		if (showProgress || debug) {
			System.out.println(
				getAlias()
					+ ": A total of "
					+ finalRuleCount
					+ " frequent itemsets were found that met the specified Minimum Support of "
					+ getMinimumSupport()
					+ "%.");
			System.out.println(
				getAlias()
					+ ": Elapsed wallclock time was "
					+ (System.currentTimeMillis() - startTime) / 1000.0
					+ " seconds");
		}

		if (finalRules == null) {
			throw new Exception(
				getAlias()
					+ ": No frequent itemsets were found that met the minimimum support of "
					+ getMinimumSupport()
					+ "%.");
		}

		this.pushOutput(finalRules, 0);
	}

	/**
	 This is how we implement the apriori algorithm:
	 <ol>
	 <li>set up a bit matrix with one row for each set, one bit for each
	 item index, with the bit set at an entry if that item exists in that
	 set.
	 <li>get the initial list of all the items we are interested in. This
	  means finding all the items that occur in more sets than than a
	  percentage defined by the <code>support</code> property.
	 <li>while we are still finding valid rules meeting our support criterion,
	 <li>convert the list of integers to an array of booleans, one bit for
	  each possible item, that bit being set if the item is of interest.
	 <li>compile the next set of rules by computing the support for each o
	  the possible resulting rules (checking against the bit matrix for
	  efficiency) and then discarding any rules that don't pass muster.
	 <li>compile the list of all possible indices again,
	 <li> backto step 3.
	 </ol>
	 */

	int attributeCount;
	HashMap sNames;
	boolean done = true;
	boolean[] currentItemsFlags;
	int numExamples;
	int[] targetIndices;
	String[] nameAry;
	public void doit() throws Exception {
		HashMap names = sNames;

		// get the item names, and the sets, from these num items and num examples.
		if (documentMap == null) {
			done = false;
			ItemSets iss = (ItemSets) this.pullInput(0);
			sNames = iss.unique;
			targetIndices = iss.targetIndices;
			names = sNames;
			nameAry = iss.names;
			numExamples = iss.numExamples;
			cutoff = (int) ((double) numExamples * (support / 100.0));
			if (((double) numExamples * (support / 100.0)) > (double) cutoff) {
				cutoff++;
			}
			int numItems = names.size();

			// Compile an array of names where the name is referenced by he index.
			nameList = iss.names;
			if (debug) {
				for (int i = 0; i < nameList.length; i++) {
					System.out.println("Apriori -> " + i + ":" + nameList[i]);
				}
				System.out.println("Apriori -> --------------------------");
				System.out.println(
					"Apriori -> number of examples : " + numExamples);
				System.out.println("Apriori -> cutoff : " + cutoff);
				System.out.println(
					"Apriori -> number of unique items : " + numItems);
				System.out.println("Apriori -> --------------------------");
			}

			boolean[][] itemFlags = iss.getItemFlags();
			documentMap = new MutableIntegerArray[numItems];
			currentItemsFlags = new boolean[numItems];

			//////////////////////
			// First set up the doc list for each item, that is the indices
			// of all the examples that contain the item. Don't bother for
			// items which don't meet the support criterion.
			for (int i = 0; i < numItems; i++) {
				String item_desc = nameList[i];
				int[] count_id = (int[]) names.get(item_desc);
				if (count_id[0] >= cutoff) {

					// This item is of interest, has sufficient support.
					currentItemsFlags[i] = true;
					documentMap[i] = new MutableIntegerArray(numExamples);
					int[] tmp = new int[1];
					tmp[0] = i;
					results.add(new LocalResultSet(tmp, documentMap[i]));
					for (int j = 0; j < numExamples; j++) {
						if (itemFlags[j][i] == true) {

							// The example contained this item, so add the
							// example to the doc list.
							documentMap[i].add(j);
						}
					}
				}
			}
			itemFlags = null;
			iss.userData = documentMap;
			attributeCount = 2; // number attributes to include in the rule
		}

		// The rules themselves will actually be stored in a vector where
		// the first entry in the vector is a list of all the 2 item combos,
		// the second is all the 3 item combos, and so on.

		// Now convert the flags that indicate an item exists or not to a
		// sorted array of indices.
		int[] currentItemIndices =
			this.convertFlagsToIndices(currentItemsFlags);
		if (currentItemIndices == null) {
			this.finish();
			return;
		}
		if (debug) {
			System.out.println(
				"APriori -> currentItemIndices count: "
					+ currentItemIndices.length);
			System.out.print("APriori ->{");
			for (int i = 0; i < currentItemIndices.length - 1; i++) {
				System.out.print(nameList[currentItemIndices[i]] + ",");
			}
			System.out.println(
				nameList[currentItemIndices[currentItemIndices.length
					- 1]]
					+ "}");
		}

		// Generate all the new possible rules and compute their support values. Any rule
		// not meeting the support criterion returns as null. The results vector also is up
		// to date on return.
		int oldRuleSize = results.size();
		int[][] fixedResultSets =
			this.generatePossibleRules(currentItemIndices, attributeCount);
		int newRules = results.size() - oldRuleSize;
		validRules = oldRuleSize;
		if (fixedResultSets == null) {
			this.finish();
			return;
		}

		// In the first round, we will discard any rule that does not contain a target value.
		if (debug) {
			System.out.println("APriori -> new frequent itemsets: " + newRules);
		}
		attributeCount++;
		if (newRules <= 0 || attributeCount > maxSize) {
			this.finish();
			return;
		}

		// Clear the current item flags.
		int testCounter = 0;
		for (int i = 0; i < currentItemsFlags.length; i++) {
			currentItemsFlags[i] = false;

			// Set the appropriate bits.
		}
		for (int i = 0; i < fixedResultSets.length; i++) {
			if (fixedResultSets[i] != null) {
				for (int k = 0; k < fixedResultSets[i].length - 1; k++) {
					if (currentItemsFlags[fixedResultSets[i][k]] == false) {
						testCounter++;
					}
					currentItemsFlags[fixedResultSets[i][k]] = true;
				}
			}
		}
		if (debug) {
			System.out.println();
		}
	}

}
// QA Comments
// 2/28/03 - Recv from Tom
// 3/17/03 - Ruth starts QA;
//         - Changed support to be represented as a %, not at a fraction,
//           as clearer to end user.  Require it to be > 0. Renamed var
//           "support" instead of "score" to make sure I get it changed
//           everywhere it should be.
//	   - Expanded descriptions
//	   - Added property showProgress so that you can get some idea of where
//           you are without the level of detail provided by debug.
//	   - Changed some debug output - Rule is X -> Y, *not*
//           as frequent itemset (x,y).   Output was misleading as to what had
//	     been discovered to date.
//	   - Changed output port to be Frequent Itemsets, not Rules, as we don't
//           yet have rules.
// 3/18/03 - Done for now.  Want following resolved before commit to Basic.
//         - WISH: Extend to support rules that include multiple target attributes.
//	     (Actually, I think this one is okay - it's the Compute Confidence that
//           narrows rules in that way.
//
//

