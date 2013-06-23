package eesa.gui.charts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Provides a base class for a single chart object.
 * @author Philip
 */
public abstract class Chart {
    /**
     * 
     */
    private static final int BORDER_X = 15;
    /**
     * 
     */
    private static final int BORDER_Y = 15;
    /**
     * 
     */
	private static final int TEN = 10;
	/**
	 * 
	 */
    private static final int K = 1000;
    /**
     * 
     */
    private static final int M = 1000000;
    /**
     * 
     */
    private final Charts parent;
    /**
     * 
     */
    private static final Color[] COLORS = new Color[]{
        Color.RED,
        Color.BLUE,
        Color.GREEN,
        Color.MAGENTA,
        Color.CYAN,
        Color.YELLOW,
        Color.ORANGE,
        Color.PINK,
        Color.GRAY,
    };
    /**
     * 
     */
    private int currentColor = 0;
    /**
     * 
     */
    private Legend legend;
    /**
     * 
     * @param c parent charts 
     */
    public Chart(final Charts c) {
        this.parent = c;
    }    
    /**
     * 
     * @param g2D 
     */
    protected final void paintChart(final Graphics2D g2D) {
        legend = new Legend();
        g2D.setColor(Color.white);
            g2D.fillRect(0, 0, parent.getChartWidth(), parent.getChartHeight());
        g2D.setColor(Color.black);
            g2D.drawRect(0, 0, parent.getChartWidth(), parent.getChartHeight());
            g2D.translate(parent.getBorderX(), parent.getBorderY());        
                drawGraph(g2D);        
                drawLegend(g2D);
            g2D.translate(-parent.getBorderX(), -parent.getBorderY());
    }
    /**
     * 
     * @param g2D 
     */
    protected abstract void drawGraph(final Graphics2D g2D);
    /**
     * 
     * @param file
     * @param imageType
     * @param format
     * @return
     * @throws IOException 
     */
    public final boolean exportChart(final File file, final int imageType,
    		final String format)
    		throws IOException {
        BufferedImage img = new BufferedImage(parent.getWidth(), parent.getHeight(), imageType);
        Graphics2D grap = img.createGraphics();
        grap.fillRect(0, 0, img.getWidth(), img.getHeight());
        paintChart(grap);
        boolean successful = ImageIO.write(img, format, file);
        return successful;
    }
    /**
     * 
     * @return selected colour 
     */
    protected final Color getSelectedColor() {
        return COLORS[getCurrentColor()];
    }
    /**
     * 
     */
    protected final void nextColor() {
        setCurrentColor(getCurrentColor() + 1);
        if (getCurrentColor() >= COLORS.length) {
            setCurrentColor(0);
        }
    }
    /**
     * 
     * @param c
     * @param label
     */
    protected final void addToLegend(final Color c, final String label) {
        legend.addSeries(new Legend.Series(c, label));
    }
    /**
     * 
     * @param number
     * @return
     */
    protected final String formatNumber(final int number) {
        float outputValue = number;
        boolean minus = false;
        if (outputValue < 0) {
            minus = true;
            outputValue = -outputValue;
        }
        if (outputValue == 0) {
            return "0";
        } else if (outputValue > 0 && outputValue < TEN * K) {
            StringBuilder sb = new StringBuilder("" + outputValue);
            char[] s = new char[4];
            if (sb.length() >= 4) {
            	sb.getChars(0, 4, s, 0);
            } else {
            	sb.getChars(0, sb.length(), s, 0);
            }
            if (minus) {
            	return "-" + sb.toString();
            } else { return new String(s); }
        } else if (outputValue >= TEN * K && outputValue < TEN * M) {
            int k = (int) (outputValue / K);
            if (minus) { return "-" + k + "K";
            } else { return "" + k + "K";
            }
        } else if (outputValue >= TEN * M) {   //M
            int m = (int) (outputValue / M);
            if (minus) { return "-" + m + "K";
            } else { return "" + m + "K";
            }
        }
        return null;
    }    
    /**
     * 
     * @param _number
     * @return
     */
    protected final String formatNumber(final float number) {
    	float outputValue = number;
        boolean minus = false;
        if (outputValue < 0) {
            minus = true;
            outputValue = -number;
        }
        if (outputValue == 0) {
            return "" + 0;
        } else if (outputValue > 0 && outputValue < TEN * K) {
            StringBuilder sb = new StringBuilder("" + outputValue);
            	char[] s = new char[4];
            if (sb.length() >= 4) {
            	sb.getChars(0, 4, s, 0);
            } else {
            	sb.getChars(0, sb.length(), s, 0);
            }
            if (minus) {
            	return "-" + sb.toString();
            } else { return new String(s); }
        } else if (outputValue >= TEN * K && outputValue < TEN * M) {
            int k = (int) (number / K);
            if (minus) {
            	return "-" + k + "K";
            } else {
            	return "" + k + "K";
            }
        } else if (outputValue >= TEN * M) {   //M
            int m = (int) (number / M);   
            if (minus) {
            	return "-" + m + "K";
            } else {
            	return "" + m + "K";
            }
        }
        return null;
    }
    /**
     * 
     * @param g2D 
     */
    private void drawLegend(final Graphics2D g2D) {
//        g2D.drawRect(BORDER_X, BORDER_X, BORDER_X, BORDER_X);
    }
    /**
     * 
     * @return parent charts container
     */
    protected final Charts getParent() {
    	return parent;
    }
	/**
	 * @return the currentColor
	 */
	public final int getCurrentColor() {
		return currentColor;
	}
	/**
	 * @param c the currentColor to set
	 */
	public final void setCurrentColor(final int c) {
		this.currentColor = c;
	}
}
