package eesa.gui.charts.basic;

import eesa.core.ProcessorSpeedTimePeriod;
import eesa.gui.charts.Chart2D;

import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Displays a chart of the speed over time for one/more processors.
 * An option for display by ResultsDataPanel
 * @author Philip
 */
public class SpeedChart extends Chart2D {
	/**
	 * 
	 */
	private static final int Y_INTERVAL_SPACING = -10;
	/**
	 * 
	 */
	private static final int Y_NUMBER_SPACING = -15;
	/**
	 * 
	 */
	private static final int Y_AXIS_TITLE_OFFSET = -25;    
    /**
     * 
     */
    private final ProcessorSpeedTimePeriod[][][] results;
    /**
     * 
     * @param parent
     * @param r results
     */
    public SpeedChart(final SpeedCharts parent, final ProcessorSpeedTimePeriod[][][] r) {
        super(parent);
        setxAxisTitle("Time");
        setyAxisTitle("Speed");
        this.results = r;
    }
    /**
     * 
     * @param g2D 
     */
    @Override
	public final void drawData(final Graphics2D g2D) {
        Logger.getLogger(SpeedChart.class.getName()).log(Level.INFO, "Drawing Tests, NUMTESTS={0}", new Object[]{results.length});
        setCurrentColor(0);       
        for (int tR = 0; tR < results.length; tR++) {
            paintTest(g2D, results[tR]);
        }
    }    
    /**
     * 
     * @param g2D
     * @param processors  
     */
    private void paintTest(final Graphics2D g2D, final ProcessorSpeedTimePeriod[][] processors) {
       Logger.getLogger(SpeedChart.class.getName()).log(Level.INFO, "Drawing Processors, NUMPROCS={0}", new Object[]{processors.length});
        for (int pR = 0; pR < processors.length; pR++) {
            paintProcessor(g2D, processors[pR]);
            nextColor();
        }        
    }
    
    /**
     * 
     * @param g2D
     * @param periods  
     */
    private void paintProcessor(final Graphics2D g2D, final ProcessorSpeedTimePeriod[] periods) {
        g2D.setColor(getSelectedColor());
        if (periods.length > 0) {
            addToLegend(getSelectedColor(), "Test: " + periods[0].getTest().getID() + ", Processor:" + periods[0].getTest().getID());
        }
        Logger.getLogger(SpeedChart.class.getName()).log(Level.INFO, "Drawing Periods, NUMPERIODS={0}", new Object[]{periods.length});
        for (int p = 0; p < periods.length; p++) {
            paintPeriod(g2D, periods[p]);
        }
    }
    /**
     * 
     * @param g2D
     * @param pstp 
     */
    private void paintPeriod(final Graphics2D g2D, final ProcessorSpeedTimePeriod pstp) {
        SpeedCharts p = (SpeedCharts) getParent();
        g2D.drawString("x", pstp.getStartTime() * p.getScaleX(), (p.getGraphHeight() - pstp.getSpeed() * p.getScaleY()));
        g2D.drawString("x", pstp.getEndTime() * p.getScaleX(), (p.getGraphHeight() - pstp.getSpeed() * p.getScaleY()));
        g2D.drawLine(
                (int) (pstp.getStartTime() * p.getScaleX()), 
                (int) (p.getGraphHeight() - pstp.getSpeed() * p.getScaleY()), 
                (int) (pstp.getEndTime() * p.getScaleX()), 
                (int) (p.getGraphHeight() - pstp.getSpeed() * p.getScaleY()));
    }
}
