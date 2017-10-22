package eesa.gui.windows.imageExport;

import com.whiuk.philip.eesa.core.Processor;
import com.whiuk.philip.eesa.core.Test;
import eesa.gui.ImageException;
import eesa.gui.charts.Charts;
import eesa.gui.fileFilters.ImageFileFilter;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * Provides a base class for the chart image exports.
 * @author Philip
 */
public abstract class ImageExport {
	/**
	 * 
	 */
    private ImageFileFilter filter;
	/**
	 * 
	 */
    private File source;
	/**
	 * 
	 */
    private List<Test> tests;
	/**
	 * 
	 */
    private List<Processor> processors;
	/**
	 * 
	 */
    private Charts.SplitType splitType;
	/**
	 * 
	 */
    private RenderedImage image;

    /**
     * 
     * @param p processors
     */
    public final void setProcessors(final List<Processor> p) {
        this.processors = p;
    }

    /**
     * 
     * @param t tests
     */
    public final void setTests(final List<Test> t) {
        this.tests = t;
    }
    /**
     * 
     * @param text
     */
    public final void setSource(final String text) {
        setSource(new File(text));
    }
    /**
     * 
     * @param f filter
     */
    public final void setFilter(final ImageFileFilter f) {
        this.filter = f;
    }
    /**
     * 
     * @param file
     */
    private void setSource(final File file) {
        this.source = file;
    }
    /**
     * 
     * @param s
     */
    public final void setSplitType(final Charts.SplitType s) {
        this.splitType = s;
    }
    /**
     * 
     * @throws ImageException
     */
    public final void performExport() throws ImageException {
        try {
            ImageIO.write(image, filter.getEnabledFormatName(), source);
        } catch (IOException ex) {
            throw new ImageException(ex);
        }
    }
    /**
     * 
     * @return
     */
    public final List<Processor> getProcessors() {
        return this.processors;
    }
    /**
     * 
     * @return
     */
    public final List<Test> getTests() {
        return this.tests;
    }    
}
