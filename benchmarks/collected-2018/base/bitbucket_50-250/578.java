// https://searchcode.com/api/result/125476688/

/*
 * Copyright 2011-2013 Kevin A. Burton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package peregrine.task;

import peregrine.Job;
import peregrine.StructReader;
import peregrine.config.Config;
import peregrine.config.Partition;
import peregrine.io.BroadcastInput;
import peregrine.io.JobOutput;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * Represents a basic Map/Merge/Reduce code backend provided by a developer for
 * running their job.  emit, setup, teardown, etc.
 * 
 */
public interface JobDelegate extends Closeable {

    public void setBroadcastInput( List<BroadcastInput> broadcastInput );
	
    /**
     * Init this job with the output it is supposed to handle.
     */
    public void init( Job job, List<JobOutput> output );
    
    /**
     * Emit a key / value pair from the job.
     */
    public void emit( StructReader key, StructReader value );
    
    /**
     * Cleanup after this job.  Close all output, etc.
     */
    public void close() throws IOException;

    /**
     * Get the partition that a job is executing over.  This is mostly used for
     * reference purposes for a job to perform potentially partition specific
     * operations and for unit testing.
     */
    public Partition getPartition();

    public void setPartition( Partition partition );

    public Config getConfig();

    public void setConfig( Config config );

}
