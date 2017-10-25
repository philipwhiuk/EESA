package eesa.gui.charts.basic;

import eesa.gui.charts.Chart;
import eesa.gui.charts.Charts;
import eesa.gui.event.TimePeriodViewEvent;
import eesa.gui.event.TimePeriodViewEventListener;
import eesa.gui.views.TimePeriodsView;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Shows multiple {@link eesa.gui.charts.basic.SpeedChart}s in a Panel.
 * @author Philip
 */
public class SpeedCharts extends Charts implements TimePeriodViewEventListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private TimePeriodsView view;
   
    /**
     * 
     */
    static final int TIMEINTERVALCOUNT = 10;
    /**
     * 
     */
    static final int SPEEDINTERVALCOUNT = 10;
    /**
     * 
     */
    private float speedInterval;
    /**
     * 
     */
    private float timeInterval;
    
    /**
     * 
     * @param v 
     * @param t 
     */
    public SpeedCharts(final TimePeriodsView v, final SplitType t) {
        super(t);
        view = v;
        view.addTimePeriodViewEventListener(this);
        updateChartSplit();
    }
    /**
     * 
     */
    @Override
	protected final void setIntervals() {
       setXInterval(getMaxX() / TIMEINTERVALCOUNT);
       setYInterval(getMaxY() / SPEEDINTERVALCOUNT);
       setIntervalScaleX(getGraphWidth() / TIMEINTERVALCOUNT);
       setIntervalScaleY(getGraphHeight() / SPEEDINTERVALCOUNT);
    }
    @Override
	public final void updateChartSplit() {
        SplitType splitType = getSplitType();
        if (splitType.equals(SplitType.SINGLE)) {
            Chart[] charts = new Chart[]{ new SpeedChart(this, view.getAllVisiblePeriods())};
            this.setCharts(charts);
        } else if (splitType.equals(SplitType.BY_PROCESSOR)) {
            int numProcessors = view.getNumVisibleProcessors();
            ArrayList<Chart> charts = new ArrayList<Chart>(numProcessors);
            for (int p = 0; p < numProcessors; p++) {
                charts.add(new SpeedChart(this, view.getVisiblePeriodsByProcessorIndex(p)));
            }
            this.setCharts(charts.toArray(new Chart[]{}));
        } else if (splitType.equals(SplitType.BY_TEST)) {
            int numTests = view.getNumVisibleTests();
            ArrayList<Chart> charts = new ArrayList<Chart>(numTests);
            for (int t = 0; t < numTests; t++) {
                charts.add(new SpeedChart(this, view.getVisiblePeriodsByTestIndex(t)));
            }
            this.setCharts(charts.toArray(new Chart[]{}));
        }  else if (splitType.equals(SplitType.BY_BOTH)) {
            int numTests = view.getNumVisibleTests();
            int numProcessors = view.getNumVisibleProcessors();
            ArrayList<Chart> charts = new ArrayList<Chart>(numProcessors * numTests);
            for (int t = 0; t < numTests; t++) {
                for (int p = 0; p < numProcessors; p++) {
                    charts.add(new SpeedChart(this, view.getVisiblePeriodsByTestIndexProcessorIndex(t, p)));
                }
            }
            this.setCharts(charts.toArray(new Chart[]{}));
        }  
    }
	@Override
	public final void computeGraphMaximums() {
       setMaxX(view.getMaxVisibleTime());
       setMaxY(view.getMaxVisibleSpeed());
    }

    @Override
	public final void timePeriodViewStatusChanged(
			final TimePeriodViewEvent event) {
        Logger.getLogger(SpeedCharts.class.getName()).
        	log(Level.INFO, "Time Period View Status Changed Caught");
        updateChartSplit();
        repaint();
    }
	/**
	 * @return the speedInterval
	 */
	public final float getYInterval() {
		return speedInterval;
	}
	/**
	 * @param s the speedInterval to set
	 */
	public final void setYInterval(final float s) {
		this.speedInterval = s;
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
}
