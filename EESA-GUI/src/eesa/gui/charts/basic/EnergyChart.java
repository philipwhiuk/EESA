package eesa.gui.charts.basic;

import eesa.core.ProcessorSpeedTimePeriod;
import eesa.gui.charts.Chart2D;

import java.awt.Graphics2D;

/**
 * Shows an chart of energy against time for processor(s).
 * @author Philip
 */
public class EnergyChart extends Chart2D {
    /**
     * 
     */
    private final ProcessorSpeedTimePeriod[][][] results;
    /**
     * 
     * @param parent
     * @param r results
     */
    public EnergyChart(final EnergyCharts parent,
    		final ProcessorSpeedTimePeriod[][][] r) {
        super(parent);
        setxAxisTitle("Time");
        setyAxisTitle("Energy");
        this.results = r;
    }
    @Override
	public final void drawData(final Graphics2D g2D) {
       setCurrentColor(0);
       for (int tR = 0; tR < results.length; tR++) {
           paintTest(g2D, results[tR]);
       }
    }
    /**
     * 
     * @param g2D
     * @param periods 
     */
    private void paintTest(final Graphics2D g2D, final ProcessorSpeedTimePeriod[][] periods) {
        for (int pR = 0; pR < periods.length; pR++) {
            paintProcessor(g2D, periods[pR]);
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
            addToLegend(getSelectedColor(),
            		"Test: " + periods[0].getTest().getID()
            		+ ", Processor:" + periods[0].getTest().getID());
        }
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
        EnergyCharts p = (EnergyCharts) getParent();
        g2D.drawString("x",
        		pstp.getStartTime() * p.getScaleX(),
        		(int) (p.getGraphHeight() - pstp.getEnergy() * p.getScaleY()));
        g2D.drawString("x",
        		pstp.getEndTime() * p.getScaleX(),
        		(int) (p.getGraphHeight() - pstp.getEnergy() * p.getScaleY()));
        g2D.drawLine(
                (int) (pstp.getStartTime() * p.getScaleX()), 
                (int) (p.getGraphHeight() - pstp.getSpeed() * p.getScaleY()), 
                (int) (pstp.getEndTime() * p.getScaleX()), 
                (int) (p.getGraphHeight() - pstp.getSpeed() * p.getScaleY()));
    }
}
