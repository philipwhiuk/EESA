package eesa.gui.charts;

import java.awt.Graphics2D;

/**
 * Provides a base class for 2D charts.
 * @author Philip Whitehouse
 *
 */
public abstract class Chart2D extends Chart {

	/**
	 * 
	 */
	private static final int Y_AXIS_TITLE_OFFSET = 25;
	/**
	 * 
	 */
	private static final int X_AXIS_TITLE_OFFSET = 25;	
	/**
	 * 
	 */
	private static final int Y_INTERVAL_SPACING = 0;
	
	/**
	 * 
	 */
	private static final int Y_INTERVALCOUNT = 10;
	/**
	 * 
	 */
	private static final int X_INTERVALCOUNT = 10;

	/**
	 * 
	 */
	private static final int Y_NUMBER_SPACING = 0;
	
	/**
	 * Title of the x-axis.
	 */
	private String xAxisTitle;
	/**
	 * Title of the y-axis.
	 */
	private String yAxisTitle;
	
	public Chart2D(Charts c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected final void drawGraph(final Graphics2D g2D) {
		drawYAxis(g2D);
		drawXAxis(g2D);
		drawData(g2D);
	}

	/**
	 * Delegates to the actual graph to draw the data.
	 * @param g2D Graphics object
	 */
	public abstract void drawData(Graphics2D g2D);

	/**
	 * Draws the horizontal axis.
	 * @param g2D Graphics object
	 */
	private void drawXAxis(final Graphics2D g2D) {
		Charts p = getParent();
		g2D.drawLine(0, p.getGraphHeight(),
				p.getGraphWidth(),
				p.getGraphHeight());
		g2D.drawString(getxAxisTitle(),
				p.getGraphWidth() / 2,
				p.getGraphHeight() + X_AXIS_TITLE_OFFSET); 
 		
		for (int i = 0; i <= X_INTERVALCOUNT; i++) {
			//Draw the interval markers
			int x1 = (0 + (i * p.getIntervalScaleX()));
			int x2 = (0 + (i * p.getIntervalScaleX()));
			g2D.drawLine(x1, p.getGraphHeight(), x2, p.getGraphHeight() + 10);
			//Write the numbers
			String intervalValue = formatNumber(i * p.getXInterval());
			g2D.drawString(intervalValue, 4 + (i * p.getIntervalScaleX()),
					p.getGraphHeight() + 12);
		} 		
	}

	/**
	 * Draws the vertical axis.
	 * @param g2D Graphics object
	 */
	private void drawYAxis(Graphics2D g2D) {
        Charts p = getParent();
        
		g2D.drawLine(0, p.getGraphHeight(), 0, 0);
		g2D.rotate(-Math.PI / 2);
		g2D.drawString(getyAxisTitle(), -p.getGraphHeight() / 2,
				Y_AXIS_TITLE_OFFSET);
        g2D.rotate(Math.PI / 2);
	    for (int i = 0; i <= Y_INTERVALCOUNT; i++) {
	       //Draw the interval markers
	    	int y1 = getParent().getGraphHeight() - (i * p.getIntervalScaleY());
	    	int y2 = getParent().getGraphHeight() - (i * p.getIntervalScaleY());
	    	g2D.drawLine(0, y1, Y_INTERVAL_SPACING, y2);
	    	//Write the numbers
	    	String intervalValue = formatNumber((int) (i * p.getYInterval()));
	    	g2D.drawString(intervalValue, Y_NUMBER_SPACING,
	    			p.getGraphHeight() - (i * p.getIntervalScaleY()) - 2);
	    }
		 
	}

	/**
	 * @return the xAxisTitle
	 */
	public String getxAxisTitle() {
		return xAxisTitle;
	}

	/**
	 * @param xAxisTitle the xAxisTitle to set
	 */
	public void setxAxisTitle(String xAxisTitle) {
		this.xAxisTitle = xAxisTitle;
	}

	/**
	 * @return the yAxisTitle
	 */
	public String getyAxisTitle() {
		return yAxisTitle;
	}

	/**
	 * @param yAxisTitle the yAxisTitle to set
	 */
	public void setyAxisTitle(String yAxisTitle) {
		this.yAxisTitle = yAxisTitle;
	}

}
