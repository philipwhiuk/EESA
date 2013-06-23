package eesa.gui.charts.basic;

import eesa.gui.charts.Chart;
import eesa.gui.charts.Charts;
import eesa.gui.event.TimePeriodViewEvent;
import eesa.gui.event.TimePeriodViewEventListener;
import eesa.gui.views.TimePeriodsView;
import java.util.ArrayList;

/**
 * Shows multiple {@link eesa.gui.charts.basic.EnergyChart}s.
 * @author Philip
 */
public class EnergyCharts extends Charts implements TimePeriodViewEventListener {
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
    private static final int TIMEINTERVALCOUNT = 10;
    /**
     * 
     */
    private static final int ENERGYINTERVALCOUNT = 10;
    /**
     * 
     */
    private float energyInterval;
    /**
     * 
     */
    private float timeInterval;

    /**
     * 
     * @param v
     * @param t
     */
    public EnergyCharts(final TimePeriodsView v, final SplitType t) {
        super(t);
        this.view = v;
        view.addTimePeriodViewEventListener(this);
        updateChartSplit();
    }
    /**
     * 
     */
    @Override
	protected final void setIntervals() {
       setXInterval(getMaxX() / TIMEINTERVALCOUNT);
       setYInterval(getMaxY() / ENERGYINTERVALCOUNT);       
       setIntervalScaleX(getGraphWidth() / TIMEINTERVALCOUNT);
       setIntervalScaleY(getGraphHeight() / ENERGYINTERVALCOUNT);        
    }

    @Override
	public final void updateChartSplit() {
        SplitType splitType = getSplitType();
        if (splitType.equals(SplitType.SINGLE)) {
            Chart[] charts = new Chart[]{ new EnergyChart(this,
            		view.getAllVisiblePeriods())};
            this.setCharts(charts);
        } else if (splitType.equals(SplitType.BY_PROCESSOR)) {
            int numProcessors = view.getNumVisibleProcessors();
            ArrayList<Chart> charts = new ArrayList<Chart>(numProcessors);
            for (int p = 0; p < numProcessors; p++) {
                charts.add(new EnergyChart(this, view.getVisiblePeriodsByProcessorIndex(p)));
            }
            this.setCharts(charts.toArray(new Chart[]{}));
        } else if (splitType.equals(SplitType.BY_TEST)) {
            int numTests = view.getNumVisibleTests();
            ArrayList<Chart> charts = new ArrayList<Chart>(numTests);
            for (int t = 0; t < numTests; t++) {
                charts.add(new EnergyChart(this, view.getVisiblePeriodsByTestIndex(t)));
            }
            this.setCharts(charts.toArray(new Chart[]{}));
        }  else if (splitType.equals(SplitType.BY_BOTH)) {
            int numTests = view.getNumVisibleTests(), numProcessors = view.getNumVisibleProcessors();
            ArrayList<Chart> charts = new ArrayList<Chart>(numProcessors * numTests);
            for (int t = 0; t < numTests; t++) {
                for (int p = 0; p < numProcessors; p++) {
                    charts.add(new EnergyChart(this, view.getVisiblePeriodsByTestIndexProcessorIndex(t, p)));
                }
            }
            this.setCharts(charts.toArray(new Chart[]{}));
        }  
    }
	@Override
	public final void computeGraphMaximums() {
       setMaxX(view.getMaxVisibleTime());
       setMaxY((float) view.getMaxVisibleEnergy());
    }
    
    @Override
	public final void timePeriodViewStatusChanged(final TimePeriodViewEvent event) {
        updateChartSplit();
        repaint();
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
	 * @return the energyInterval
	 */
	public final float getYInterval() {
		return energyInterval;
	}
	/**
	 * @param e the energyInterval to set
	 */
	public final void setYInterval(final float e) {
		this.energyInterval = e;
	}
    
}
