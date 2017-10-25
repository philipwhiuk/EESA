package eesa.gui.charts;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * Generates and displays a panel that
 * dynamically resizes and shows multiple charts.
 * @author Philip
 */
public abstract class Charts extends JPanel implements ComponentListener {
    /**
     * Distance between charts (X).
     */
    public static final int CHARTBORDERX = 10;
    /**
     * Distance between charts (Y).
     */
    public static final int CHARTBORDERY = 10;
    /**
     * Border round a chart (X).
     */
    public static final int BORDER_X = 40;
    /**
     * Border round a chart (Y).
     */
    public static final int BORDER_Y = 40;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private SplitType splitType;
    /**
     * 
     */
    private Chart[] charts;

    /**
     * 
     */
    private int borderX;
    /**
     * 
     */
    private int graphWidth;
    /**
     * 
     */
    private int borderY;
    /**
     * 
     */
    private float maxX;
    /**
     * 
     */
    private float scaleX;
    /**
     * 
     */
    private int graphHeight;
    /**
     * 
     */
    private float maxY;
    /**
     * 
     */
    private float scaleY;
    /**
     * 
     */
    private int chartWidth;
    /**
     * 
     */
    private int chartHeight;
    /**
     * 
     */
    private int intervalScaleX;
    /**
     * 
     */
    private int intervalScaleY;

    
    /**
     * 
     */
    protected abstract void setIntervals();

    /**
     * 
     */
    public enum SplitType {

        /**
         * 
         */
        SINGLE,
        /**
         *
         */
        BY_TEST,
        /**
         *
         */
        BY_PROCESSOR,
        /**
         *
         */
        BY_BOTH;
        @Override
        public String toString() {
            switch(this) {
                case SINGLE: return "Single Chart";
                case BY_PROCESSOR: return "By Processor";
                case BY_TEST: return "By Test";
                case BY_BOTH: return "By Test & Processor";
                default: return "";
            }
        }
        /**
         * 
         * @return
         */
        public String getDescription() {
            switch(this) {
                case SINGLE: return "One chart with all selected processors and tests on.";
                case BY_PROCESSOR: return "One chart per processor, with the the results for that processor from all tests on each chart";
                case BY_TEST: return "One chart per test, with all processors used in the test shown on the chart";
                case BY_BOTH: return "A chart for each processor-test combination";
                default: return "";
            }
        }
    };
    /**
     * 
     * @param s splitType 
     */
    public Charts(final SplitType s) {
        this.splitType = s;
    }
    /**
     * 
     * @param g 
     */
    @Override
	protected final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (charts.length > 0) {
            setChartWidth((getWidth() / charts.length) - CHARTBORDERX);
        } else {
            setChartWidth(getWidth() - CHARTBORDERY);
        }
        setChartHeight(getHeight() - CHARTBORDERY);
        
        computeGraphSize();                
        Graphics2D g2D = (Graphics2D) g;
        for (int c = 0; c < charts.length; c++) {
            charts[c].paintChart(g2D);
            g2D.translate(getChartWidth() + CHARTBORDERX, 0);
        }
    }
    /**
     * 
     * @return
     */
    public final SplitType getSplitType() {
        return this.splitType;
    }    
    /**
     * 
     * @param s splitType 
     */
    public final void setSplitType(final SplitType s) {
        this.splitType = s;
        updateChartSplit();
        repaint();
    }
    /**
     * 
     * @param c charts 
     */
    protected final void setCharts(final Chart[] c) {
        this.charts = c;
        Logger.getLogger(Charts.class.getName()).log(Level.INFO, "Charts Updated, NUMCHARTS: {0}", charts.length);                
    }
    /**
     * 
     */
    public abstract void updateChartSplit();   
    /**
     * 
     */
    protected final void computeGraphSize() {
        computeGraphMaximums();
        //borderX = (chartWidth*BORDER_X)/100;
        setBorderX(BORDER_X);
        //borderY = (chartHeight*BORDER_Y)/100;
        setBorderY(BORDER_Y);
        setGraphWidth((getChartWidth() - 2 * getBorderX()));
        setGraphHeight((getChartHeight() - 2 * getBorderY()));
        if (getMaxX() != 0) {
            setScaleX((getGraphWidth() / getMaxX()));
        }
        if (getMaxY() != 0) {
            setScaleY((getGraphHeight() / getMaxY()));
        }
        setIntervals();
    }
    /**
     * 
     */
    public abstract void computeGraphMaximums();
    
    @Override
	public final void componentResized(final ComponentEvent e) {
        setSize(e.getComponent().getSize());
        repaint();
    }

    @Override
    public void componentMoved(final ComponentEvent e) {
    }

    @Override
    public void componentShown(final ComponentEvent e) {
    }

    @Override
    public void componentHidden(final ComponentEvent e) {
    }
	/**
	 * @return the scaleY
	 */
	public final float getScaleY() {
		return scaleY;
	}
	/**
	 * @param y the scaleY to set
	 */
	public final void setScaleY(final float y) {
		this.scaleY = y;
	}
	/**
	 * @return the scaleX
	 */
	public final float getScaleX() {
		return scaleX;
	}
	/**
	 * @param x the scaleX to set
	 */
	public final void setScaleX(final float x) {
		this.scaleX = x;
	}
	/**
	 * @return the intervalScaleX
	 */
	public final int getIntervalScaleX() {
		return intervalScaleX;
	}
	/**
	 * @param x the intervalScaleX to set
	 */
	public final void setIntervalScaleX(final int x) {
		this.intervalScaleX = x;
	}
	/**
	 * @return the intervalScaleY
	 */
	public final int getIntervalScaleY() {
		return intervalScaleY;
	}
	/**
	 * @param y the intervalScaleY to set
	 */
	public final void setIntervalScaleY(final int y) {
		this.intervalScaleY = y;
	}
	/**
	 * @return the borderX
	 */
	public final int getBorderX() {
		return borderX;
	}
	/**
	 * @param x the borderX to set
	 */
	public final void setBorderX(final int x) {
		this.borderX = x;
	}
	/**
	 * @return the chartWidth
	 */
	public final int getChartWidth() {
		return chartWidth;
	}
	/**
	 * @param w the chartWidth to set
	 */
	public final void setChartWidth(final int w) {
		this.chartWidth = w;
	}
	/**
	 * @return the chartHeight
	 */
	public final int getChartHeight() {
		return chartHeight;
	}
	/**
	 * @param h the chartHeight to set
	 */
	public final void setChartHeight(final int h) {
		this.chartHeight = h;
	}
	/**
	 * @return the borderY
	 */
	public final int getBorderY() {
		return borderY;
	}
	/**
	 * @param y the borderY to set
	 */
	public final void setBorderY(final int y) {
		this.borderY = y;
	}
	/**
	 * @return the graphHeight
	 */
	public final int getGraphHeight() {
		return graphHeight;
	}
	/**
	 * @param h the graphHeight to set
	 */
	public final void setGraphHeight(final int h) {
		this.graphHeight = h;
	}
	/**
	 * @return the graphWidth
	 */
	public final int getGraphWidth() {
		return graphWidth;
	}
	/**
	 * @param w the graphWidth to set
	 */
	public final void setGraphWidth(final int w) {
		this.graphWidth = w;
	}
	/**
	 * @return the maxX
	 */
	public final float getMaxX() {
		return maxX;
	}
	/**
	 * @param x the maxX to set
	 */
	public final void setMaxX(final float x) {
		this.maxX = x;
	}
	/**
	 * @return the maxY
	 */
	public final float getMaxY() {
		return maxY;
	}
	/**
	 * @param y the maxY to set
	 */
	public final void setMaxY(final float y) {
		this.maxY = y;
	}
	/**
	 * 
	 * @return
	 */
	public abstract float getXInterval();
	/**
	 * 
	 * @return
	 */
	public abstract float getYInterval();
}
