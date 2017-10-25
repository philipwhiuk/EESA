package eesa.gui.charts;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Stores and renders a legend of information on a chart.
 * @author Philip
 */
public class Legend {
    /**
     * 
     */
    private ArrayList<Series> series;
    /**
     * 
     */
    public Legend() {
        series = new ArrayList<Series>(1);
    }
    /**
     * 
     * @param s
     */
    final void addSeries(final Series s) {
        series.add(s);
    }
    /**
     * 
     */
    static class Series {
        /**
         * 
         */
        private final Color color;
        /**
         * 
         */
        private final String label;

        /**
         * 
         * @param c colour
         * @param l label
         */
        Series(final Color c, final String l) {
            this.color = c;
            this.label = l;
        }
    }

    
}
