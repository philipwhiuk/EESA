package eesa.gui.charts.basic;

import com.whiuk.philip.eesa.core.Job;
import com.whiuk.philip.eesa.core.JobResult;
import eesa.gui.charts.Chart2D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Shows the jobs against time.
 * @author Philip
 */
public class JobChart extends Chart2D {
    /**
     * 
     */
    public static enum View {

        /**
         *
         */
        Weight,
        /**
         *
         */
        Density
    };
    /**
     * 
     */
    private JobResult[][][] results;
    /**
     * 
     */
    private View viewParam = View.Weight;

    /**
     * 
     * @param parent Parent chart
     * @param r Results
     */
    public JobChart(final JobCharts parent, final JobResult[][][] r) {
        super(parent);
        setxAxisTitle("Time");
        setyAxisTitle("Jobs");
        this.results = r;
    }
    
    @Override
	public final void drawData(final Graphics2D g2D) {
       setCurrentColor(0);
        Logger.getLogger(SpeedChart.class.getName()).log(Level.INFO, "Drawing Tests, NUMTESTS={0}", new Object[]{results.length});
       for (int tR = 0; tR < results.length; tR++) {
           paintTest(g2D, results[tR]);
       }
    }
    /**
     * 
     * @param g2D
     * @param processors  
     */
    private void paintTest(final Graphics2D g2D,
    		final JobResult[][] processors) {
       Logger.getLogger(SpeedChart.class.getName()).log(Level.INFO, "Drawing Processors, NUMPROCS={0}", new Object[]{processors.length});
        for (int jR = 0; jR < processors.length; jR++) {
            paintProcessor(g2D, processors[jR]);
            nextColor();
        }        
    }    /**
     * 
     * @param g2D
     * @param r results 
     */
    private void paintProcessor(final Graphics2D g2D, final JobResult[] r) {
        g2D.setColor(getSelectedColor());
//       Logger.getLogger(SpeedChart.class.getName()).log(Level.INFO, "Drawing Jobs, NUMJOBS={0}",new Object[]{results.length});
        if (r.length > 0) {
            addToLegend(getSelectedColor(), "Test: " + r[0].getTest().getID() + ", Processor:" + r[0].getTest().getID());
            for (int p = 0; p < r.length; p++) {
                paintJob(g2D, r[p]);
            }        
        }
    }
    /**
     * 
     * @param g2D
     * @param j
     */
    private void paintJob(final Graphics2D g2D, final JobResult j) {
        JobCharts p = (JobCharts) getParent();
        Job job = j.getJob();
        int yPos = (int) ((p.getMaxY() - 1 - j.getID()) * p.getScaleY());
        g2D.fillRect((int) (job.getReleaseTime() * p.getScaleX()), 
                    yPos, 
                    (int) (job.getLength() * p.getScaleX()), 
                    (int) p.getScaleY());
        g2D.setColor(Color.black);
        switch(viewParam) {
            case Weight: g2D.drawString("" + j.getJob().getWeight(), 
                (int) ((job.getReleaseTime() + job.getDensity() / 2) * p.getScaleX()), 
                yPos - 3);
                break;
            case Density: g2D.drawString("" + job.getDensity(), 
                (int) ((job.getReleaseTime() + job.getDensity() / 2) * p.getScaleX()), 
                yPos - 3);
                break;
            default: throw new RuntimeException("Invalid view parameter");
        }
        g2D.setColor(this.getSelectedColor());
    }


}
