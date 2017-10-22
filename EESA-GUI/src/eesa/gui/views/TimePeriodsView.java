package eesa.gui.views;

import com.whiuk.philip.eesa.core.Processor;
import com.whiuk.philip.eesa.core.ProcessorSpeedTimePeriod;
import com.whiuk.philip.eesa.core.Test;
import com.whiuk.philip.eesa.core.TestList;
import eesa.gui.ResultsDataPanel;
import eesa.gui.event.ProcessorViewEvent;
import eesa.gui.event.TestViewEvent;
import eesa.gui.event.TimePeriodViewEvent;
import eesa.gui.event.TimePeriodViewEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JList;

/**
 * Provides a {@link ResultsDataView} that filters time periods.
 * @author Philip
 */
public class TimePeriodsView extends ResultsDataView {
    /**
     * 
     */
    private ArrayList<ProcessorSpeedTimePeriod> visibleResults;
    /**
     * 
     */
    private ProcessorSpeedTimePeriod[] results;
    /**
     * 
     */
    private boolean[] showResult;
    /**
     * 
     */
    private ArrayList<TimePeriodViewEventListener> listeners;
    
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
    private ArrayList<ArrayList<
    	ArrayList<ProcessorSpeedTimePeriod>>> visiblePeriods;
    /**
     * 
     */
    private float maxVisibleTime;
    /**
     * 
     */
    private float maxVisibleSpeed;
    /**
     * 
     */
    private double maxVisibleEnergy;
    
    /**
     * 
     * @param panel 
     * @param t
     * @param p
     */
    public TimePeriodsView(final ResultsDataPanel panel,
    		final TestList t,
    		final Processor[] p) {
        super(panel, t, p);
        visibleResults = new ArrayList<ProcessorSpeedTimePeriod>();
        visiblePeriods = new ArrayList<ArrayList<ArrayList<ProcessorSpeedTimePeriod>>>();
        listeners = new ArrayList<TimePeriodViewEventListener>();
        getTestList().compilePeriods();
        results = t.getPeriods();
        showResult = new boolean[results.length];
        


    }
    @Override
	public final int getNumVisibleResults() {
        return visibleResults.size();
    }

    /**
     * 
     * @param event
     */
    @Override
	public final void testViewStatusChanged(final TestViewEvent event) {
        @SuppressWarnings("unchecked")
		List<Test> tests = ((JList<Test>) event.getSource())
			.getSelectedValuesList();
        setSelectedTests(tests);
        numVisibleTests = tests.size();
        constructPeriodList();
        refreshSelected();
    }
    
    /**
     * 
     * @param event
     */
    @Override
	public final void processorViewStatusChanged(final ProcessorViewEvent event) {
    	@SuppressWarnings("unchecked")
		List<Processor> processors = ((JList<Processor>) event.getSource()).getSelectedValuesList();
        setSelectedProcessors(processors);
        numVisibleProcessors = processors.size();        
        constructPeriodList();        
        refreshSelected();
    }
    /**
     * 
     */
    private void refreshSelected() {
        maxVisibleTime = 0;
        visibleResults = new ArrayList<ProcessorSpeedTimePeriod>();
        for (int p = 0; p < results.length; p++) {
            addPeriodIfSelected(results[p],
            		getSelectedProcessors(),
            		getSelectedTests());
        }
        fireJobResultViewEvent();
    }
    /**
     * 
     * @param pSTR period
     * @param processors Processors
     * @param tests Tests
     */
    private void addPeriodIfSelected(
    		final ProcessorSpeedTimePeriod pSTR,
    		final List<Processor> processors,
    		final List<Test> tests) {
        for (Processor p: processors) {
           if (pSTR.getProcessor().equals(p)) {
        	   for (Test t: tests) {
                    if (pSTR.getTest().equals(t)) {
                        visibleResults.add(pSTR);
                        visiblePeriods.get(processors.indexOf(p))
                        	.get(processors.indexOf(t)).add(pSTR);
                        if (pSTR.getEndTime() > maxVisibleTime) {
                            maxVisibleTime = pSTR.getEndTime();
                        }
                        if (pSTR.getSpeed() > maxVisibleSpeed) {
                            maxVisibleSpeed = pSTR.getSpeed();
                        }
                        if (pSTR.getSpeed() > maxVisibleEnergy) {
                            maxVisibleEnergy = pSTR.getEnergy();
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
        Iterator<TimePeriodViewEventListener> i = listeners.iterator();
        while (i.hasNext()) {
            i.next().timePeriodViewStatusChanged(new TimePeriodViewEvent(this));
        }
    }
    /**
     * 
     * @param l 
     */
    public final void addTimePeriodViewEventListener(final TimePeriodViewEventListener l) {
        listeners.add(l);
    }
    /**
     * 
     * @param l 
     */
    public final void removeTimePeriodViewEventListener(final TimePeriodViewEventListener l) {
        listeners.remove(l);
    }

    /**
     * 
     * @param rowIndex
     * @return
     */
    public final ProcessorSpeedTimePeriod getVisibleResult(final int rowIndex) {
        return visibleResults.get(rowIndex);
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
    public final float getMaxVisibleSpeed() {
        return maxVisibleSpeed;
    }
    /**
     * 
     * @return
     */
    public final double getMaxVisibleEnergy() {
        return maxVisibleEnergy;
    }
    
    /**
     * 
     * @return
     */
    public final ProcessorSpeedTimePeriod[][][] getAllVisiblePeriods() {
        ProcessorSpeedTimePeriod[][][] periods = new ProcessorSpeedTimePeriod[numVisibleTests][][];
        for (int t = 0; t < numVisibleTests; t++) {
            periods[t] = new ProcessorSpeedTimePeriod[numVisibleProcessors][];
            for (int p = 0; p < numVisibleProcessors; p++) {
                periods[t][p] = visiblePeriods.get(t).get(p).toArray(new ProcessorSpeedTimePeriod[]{});
            }
        }
        return periods;
    }
    /**
     * 
     * @param t
     * @return
     */
    public final ProcessorSpeedTimePeriod[][][] getVisiblePeriodsByTestIndex(final int t) {
        ProcessorSpeedTimePeriod[][][] periods = new ProcessorSpeedTimePeriod[1][][];
        periods[0] = new ProcessorSpeedTimePeriod[numVisibleProcessors][];
        for (int p = 0; p < numVisibleProcessors; p++) {
            periods[0][p] = visiblePeriods.get(t).get(p).toArray(new ProcessorSpeedTimePeriod[]{});
        }
        return periods;
    }
    /**
     * 
     * @param p
     * @return
     */
    public final ProcessorSpeedTimePeriod[][][] getVisiblePeriodsByProcessorIndex(final int p) {
        ProcessorSpeedTimePeriod[][][] periods = new ProcessorSpeedTimePeriod[numVisibleTests][][];
        for (int t = 0; t < numVisibleTests; t++) {
            periods[t] = new ProcessorSpeedTimePeriod[1][];
            periods[t][0] = visiblePeriods.get(t).get(p).toArray(new ProcessorSpeedTimePeriod[]{});
        }
        return periods;
    }

    /**
     * 
     * @param t
     * @param p
     * @return
     */
    public final ProcessorSpeedTimePeriod[][][] getVisiblePeriodsByTestIndexProcessorIndex(final int t, final int p) {
        ProcessorSpeedTimePeriod[][][] periods = new ProcessorSpeedTimePeriod[1][][];
        periods[0] = new ProcessorSpeedTimePeriod[1][];
        periods[0][0] = visiblePeriods.get(t).get(p).toArray(new ProcessorSpeedTimePeriod[]{});
        return periods;
    }

    /**
     * 
     */
    private void constructPeriodList() {
        visiblePeriods = new ArrayList<ArrayList<ArrayList<ProcessorSpeedTimePeriod>>>();
        for (int t = 0; t < getSelectedTests().size(); t++) {
            ArrayList<ArrayList<ProcessorSpeedTimePeriod>> testPeriods = new ArrayList<ArrayList<ProcessorSpeedTimePeriod>>();
            for (int p = 0; p < getSelectedProcessors().size(); p++) {                
                ArrayList<ProcessorSpeedTimePeriod> processorPeriods = new ArrayList<ProcessorSpeedTimePeriod>();
                testPeriods.add(processorPeriods);
            }
            visiblePeriods.add(testPeriods);
        }
    }


}
