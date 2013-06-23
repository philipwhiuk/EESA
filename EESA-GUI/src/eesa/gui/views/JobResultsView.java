package eesa.gui.views;

import eesa.core.JobResult;
import eesa.core.Processor;
import eesa.core.Test;
import eesa.core.TestList;
import eesa.gui.ResultsDataPanel;
import eesa.gui.event.JobResultViewEvent;
import eesa.gui.event.JobResultViewEventListener;
import eesa.gui.event.ProcessorViewEvent;
import eesa.gui.event.TestViewEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JList;

/**
 * Provides a {@link ResultsDataView} that filters job results.
 * @author Philip
 */
public class JobResultsView extends ResultsDataView  {
    /**
     * 
     */
    private JobResult[] results;
    /**
     * 
     */
    private boolean[] showResult;
    /**
     * 
     */
    private ArrayList<JobResultViewEventListener> listeners;
    /**
     * 
     */
    private ArrayList<JobResult> visibleResults;
    
    /**
     * 
     */
    private int numVisibleTests;
    /**
     * 
     */
    private int numVisibleProcessors;
    /**
     * 
     */
    private ArrayList<ArrayList<ArrayList<JobResult>>> visibleResultsMulti;
    /**
     * 
     */
    private float maxVisibleTime;
    /**
     * 
     */
    private int maxVisibleJob;
    
    /**
     * 
     * @param panel
     * @param t
     * @param p
     */
    public JobResultsView(final ResultsDataPanel panel,
    		final TestList t,
    		final Processor[] p) {
        super(panel, t, p);
        visibleResults = new ArrayList<JobResult>();
        listeners = new ArrayList<JobResultViewEventListener>();
        getTestList().compileResults();
        results = t.getResults();
        showResult = new boolean[results.length];
    }
    /**
     * 
     * @param event
     */
    @Override
	public final void testViewStatusChanged(final TestViewEvent event) {
        //Logger.getLogger(JobResultsView.class.getName()).log(Level.INFO, "Test View Status Changed Caught");
        @SuppressWarnings("unchecked")
		List<Test> tests = ((JList<Test>) event.getSource()).getSelectedValuesList();   
        setSelectedTests(tests);
        numVisibleTests = tests.size();
        refreshSelected();
    }
    /**
     * 
     * @param event
     */
    @Override
	public final void processorViewStatusChanged(final ProcessorViewEvent event) {
        //Logger.getLogger(JobResultsView.class.getName()).log(Level.INFO, "Processor View Status Changed Caught");
        @SuppressWarnings("unchecked")
		List<Processor> processors = ((JList<Processor>) event.getSource()).getSelectedValuesList();
        setSelectedProcessors(processors);
        numVisibleProcessors = processors.size();
        refreshSelected();
    }
    /**
     * 
     */
    private void refreshSelected() {
        //Logger.getLogger(JobResultsView.class.getName()).log(Level.INFO, "Refreshing Job Results View");
        visibleResults = new ArrayList<JobResult>();
        constructJobResultList();
        maxVisibleTime = 0;
        for (int j = 0; j < results.length; j++) {
            addJobResultIfSelected(results[j], getSelectedProcessors(), getSelectedTests());
        }
        //Logger.getLogger(JobResultsView.class.getName()).log(Level.INFO, "Refreshed Job Results View. NUM_VISIBLE: {0}",visibleResults.size());        
        fireJobResultViewEvent();
    }    
    /**
     * 
     * @param jR
     * @param list
     * @param list2
     * @return
     */
    private void addJobResultIfSelected(final JobResult jR,
    		final List<Processor> processors,
    		final List<Test> tests) {
    	for (Processor p: processors) {
           if (jR != null & jR.getProcessor() != null & jR.getProcessor().equals(p)) {
                for (Test t: tests) {
                    if (jR.getTest().equals(t)) {
                        visibleResults.add(jR);
                        visibleResultsMulti.get(tests.indexOf(t)).get(processors.indexOf(p)).add(jR);
                        if (maxVisibleJob < jR.getID()) {
                            maxVisibleJob = jR.getID();
                        }
                        if (maxVisibleTime < jR.getJob().getDeadlineTime()) {
                            maxVisibleTime = jR.getJob().getDeadlineTime();
                        }
                        return;
                    }
                }
                return;
           }
        }
    }

    /**
     * 
     */
    private void fireJobResultViewEvent() {
        Iterator<JobResultViewEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().jobResultViewStatusChanged(new JobResultViewEvent(this));
        }
    }

    @Override
	public final int getNumVisibleResults() {
        return visibleResults.size();
    }

    /**
     * 
     * @param rowIndex
     * @return
     */
    public final JobResult getVisibleResult(final int rowIndex) {
        return visibleResults.get(rowIndex);
    }
    /**
     * 
     * @param l
     */
    public final void addJobResultViewEventListener(
    		final JobResultViewEventListener l) {
        listeners.add(l);
    }
    /**
     * 
     * @param l
     */
    public final void removeJobResultViewEventListener(
    		final JobResultViewEventListener l) {
        listeners.remove(l);
    }

    /**
     * 
     * @return
     */
    public final JobResult[][][] getAllVisibleJobResults() {
        JobResult[][][] jobResults = new JobResult[numVisibleTests][][];
        for (int t = 0; t < numVisibleTests; t++) {
            ArrayList<ArrayList<JobResult>> visibleTPeriods = visibleResultsMulti.get(t);
            jobResults[t] = new JobResult[numVisibleProcessors][];
            for (int p = 0; p < numVisibleProcessors; p++) {
                ArrayList<JobResult> visibleTPPeriods = visibleTPeriods.get(p);
                jobResults[t][p] = visibleTPPeriods.toArray(new JobResult[]{});
            }
        }
        return jobResults;
    }
    /**
     * 
     * @param t
     * @return
     */
    public final JobResult[][][] getVisibleJobResultsByTestIndex(final int t) {
        JobResult[][][] jobResults = new JobResult[1][][];
        jobResults[0] = new JobResult[numVisibleProcessors][];
        for (int p = 0; p < numVisibleProcessors; p++) {
            jobResults[0][p] = visibleResultsMulti.get(t).get(p).toArray(new JobResult[]{});
        }
        return jobResults;
    }
    /**
     * 
     * @param p
     * @return
     */
    public final JobResult[][][] getVisibleJobResultsByProcessorIndex(final int p) {
        JobResult[][][] jobResults = new JobResult[numVisibleTests][][];
        for (int t = 0; t < numVisibleTests; t++) {
            jobResults[t] = new JobResult[1][];
            jobResults[t][0] = visibleResultsMulti.get(t).get(p).toArray(new JobResult[]{});
        }
        return jobResults;
    }

    /**
     * 
     * @param t
     * @param p
     * @return
     */
    public final JobResult[][][] getVisibleJobResultsByTestIndexProcessorIndex(final int t, final int p) {
        JobResult[][][] jobResults = new JobResult[1][][];
        jobResults[0] = new JobResult[1][];
        jobResults[0][0] = visibleResultsMulti.get(t).get(p).toArray(new JobResult[]{});
        return jobResults;
    }

    /**
     * 
     */
    private void constructJobResultList() {
        visibleResultsMulti = new ArrayList<ArrayList<ArrayList<JobResult>>>();
        for (int t = 0; t < getSelectedTests().size(); t++) {
            ArrayList<ArrayList<JobResult>> testPeriods = new ArrayList<ArrayList<JobResult>>();
            for (int p = 0; p < getSelectedProcessors().size(); p++) {
                ArrayList<JobResult> processorPeriods = new ArrayList<JobResult>();
                testPeriods.add(processorPeriods);
            }
            visibleResultsMulti.add(testPeriods);
        }  
    }

    /**
     * 
     * @return
     */
    public final float getMaxVisibleTime() {
        return maxVisibleTime;
    }

    /**
     * 
     * @return
     */
    public final int getMaxVisibleJob() {
        return maxVisibleJob;
    }
}
