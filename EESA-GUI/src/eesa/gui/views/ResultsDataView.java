package eesa.gui.views;

import java.util.ArrayList;
import java.util.List;

import eesa.core.Processor;
import eesa.core.Test;
import eesa.core.TestList;
import eesa.gui.ResultsDataPanel;
import eesa.gui.event.ProcessorViewEventListener;
import eesa.gui.event.TestViewEventListener;

/**
 * Provides a mechanism to filter data according user selections.
 * @author Philip
 */
public abstract class ResultsDataView implements TestViewEventListener, ProcessorViewEventListener {
    /**
     * 
     */
	private List<Test> selectedTests;
    /**
     * 
     */
    private List<Processor> selectedProcessors;
    /**
     * 
     */
    private final TestList testList;
    /**
     * 
     */
    private final Processor[] processors;
    
    /**
     * 
     * @param panel 
     * @param t
     * @param p 
     */
    public ResultsDataView(final ResultsDataPanel panel,
    		final TestList t,
    		final Processor[] p) {
        selectedTests = new ArrayList<Test>();
        selectedProcessors = new ArrayList<Processor>(); 
        panel.addTestViewEventListener(this);
        panel.addProcessorViewEventListener(this);
        testList = t;
        processors = p;
        
    }
    /**
     * 
     * @return The number of results visible under the current view
     */
    public abstract int getNumVisibleResults();
    /**
     * 
     * @return 
     */
    public final int getNumVisibleTests() {
        return selectedTests.size();
    }
    /**
     * 
     * @return 
     */
    public final int getNumVisibleProcessors() {
        return selectedProcessors.size();
    }    
    /**
     * 
     * @param t tests
     */
    protected final void setSelectedTests(final List<Test> t) {
    	this.selectedTests = t;
    }
    /**
     * 
     * @param p Processors
     */
    protected final void setSelectedProcessors(final List<Processor> p) {
    	this.selectedProcessors = p;
    }
    /**
     * 
     * @return selected tests
     */
    protected final List<Test> getSelectedTests() {
    	return selectedTests;
    }
    /**
     * 
     * @return Processors
     */
    protected final List<Processor> getSelectedProcessors() {
    	return selectedProcessors;
    }   
    /**
     * @return 
     * 
     */
    protected final TestList getTestList() {
    	return testList;  	
    }
}
