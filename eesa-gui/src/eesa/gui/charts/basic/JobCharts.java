package eesa.gui.charts.basic;

import eesa.gui.charts.Chart;
import eesa.gui.charts.Charts;
import eesa.gui.event.JobResultViewEvent;
import eesa.gui.event.JobResultViewEventListener;
import eesa.gui.views.JobResultsView;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Shows multiple {@link eesa.gui.charts.basic.JobChart}s in a Panel.
 * @author Philip
 */
public class JobCharts extends Charts implements JobResultViewEventListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    static final int TIMEINTERVALCOUNT = 10;
    /**
     * 
     */
    static final int JOBSINTERVALCOUNT = 1;
    /**
     * 
     */
    private JobResultsView view;
    /**
     * 
     */
    private float jobInterval;
    /**
     * 
     */
    private float timeInterval;
    
    /**
     * 
     * @param v 
     * @param t
     */
    public JobCharts(final JobResultsView v, final SplitType t) {
        super(t);
        this.view = v;
        view.addJobResultViewEventListener(this);
        updateChartSplit();        
    }
    @Override
	public final void jobResultViewStatusChanged(
			final JobResultViewEvent event) {
        updateChartSplit();
        repaint();
    }
    
    @Override
	public final void updateChartSplit() {
        SplitType splitType = getSplitType();
        Logger.getLogger(JobCharts.class.getName()).log(Level.INFO, "Updating Charts, SplitType={0}", new Object[]{splitType});
        if (splitType.equals(SplitType.SINGLE)) {
            Chart[] charts = new Chart[]{ new JobChart(this, view.getAllVisibleJobResults())};
            this.setCharts(charts);
        } else if (splitType.equals(SplitType.BY_PROCESSOR)) {
            int numProcessors = view.getNumVisibleProcessors();
            ArrayList<Chart> charts = new ArrayList<Chart>(numProcessors);
            for (int p = 0; p < numProcessors; p++) {
                charts.add(new JobChart(this, view.getVisibleJobResultsByProcessorIndex(p)));
            }
            this.setCharts(charts.toArray(new Chart[]{}));
        } else if (splitType.equals(SplitType.BY_TEST)) {
            int numTests = view.getNumVisibleTests();
            ArrayList<Chart> charts = new ArrayList<Chart>(numTests);
            for (int t = 0; t < numTests; t++) {
                charts.add(new JobChart(this, view.getVisibleJobResultsByTestIndex(t)));
            }
            this.setCharts(charts.toArray(new Chart[]{}));
        } else if (splitType.equals(SplitType.BY_BOTH)) {
            int numTests = view.getNumVisibleTests(), numProcessors = view.getNumVisibleProcessors();
            ArrayList<Chart> charts = new ArrayList<Chart>(numProcessors * numTests);
            for (int t = 0; t < numTests; t++) {
                for (int p = 0; p < numProcessors; p++) {
                    charts.add(new JobChart(this, view.getVisibleJobResultsByTestIndexProcessorIndex(t, p)));
                }
            }
            this.setCharts(charts.toArray(new Chart[]{}));
        }  
    }
    @Override
	public final void computeGraphMaximums() {
       setMaxX(view.getMaxVisibleTime());
       setMaxY(view.getMaxVisibleJob());
       if (getMaxY() < 10) { setMaxY(10); }
    }

    @Override
	protected final void setIntervals() {
       setXInterval(getMaxX() / TIMEINTERVALCOUNT);
       setYInterval(getMaxY() / JOBSINTERVALCOUNT);       
       setIntervalScaleX(getGraphWidth() / TIMEINTERVALCOUNT);
       setIntervalScaleY(getGraphHeight() / JOBSINTERVALCOUNT); 
    }
	/**
	 * @return the timeInterval
	 */
	public final float getXInterval() {
		return timeInterval;
	}
	/**
	 * @param t the timeInterval to set
	 */
	public final void setXInterval(final float t) {
		this.timeInterval = t;
	}
	/**
	 * @return the jobInterval
	 */
	public final float getYInterval() {
		return jobInterval;
	}
	/**
	 * @param j the jobInterval to set
	 */
	public final void setYInterval(final float j) {
		this.jobInterval = j;
	}

}
