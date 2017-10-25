package com.whiuk.philip.eesa.event;

import com.whiuk.philip.eesa.core.JobResult;

/**
 * Provides information about changes to a job result.
 * @author Philip
 */
public class JobResultEvent extends EventObject {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     * @param jr job result
     */
    public JobResultEvent(final JobResult jr) {
        super(jr);
    }
}
