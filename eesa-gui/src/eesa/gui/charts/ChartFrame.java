package eesa.gui.charts;

import javax.swing.JFrame;

/**
 * Manages a frame to render charts.
 * @author Philip
 */
public class ChartFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private final Charts chart;
    /**
     * 
     */
    public static final int WIDTH = 640;
    /**
     * 
     */
    public static final int HEIGHT = 480;
    /**
     * 
     * @param c
     */
    public ChartFrame(final Charts c) {
        super();
        chart = c;
        setSize(WIDTH, HEIGHT);
        setSize(320, 240);
        add(chart);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
