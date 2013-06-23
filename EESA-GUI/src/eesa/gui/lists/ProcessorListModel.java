package eesa.gui.lists;

import eesa.core.Processor;
import java.util.ArrayList;

/**
 * Provides a {@link javax.swing.ListModel} implementation 
 * to show the list of processors.
 * @author Philip
 */
public class ProcessorListModel 
	extends javax.swing.AbstractListModel<Processor> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private final ArrayList<Processor> p;

    /**
     * 
     * @param processors
     */
    public ProcessorListModel(final ArrayList<Processor> processors) {
        this.p = processors;
    }
    @Override
	public final int getSize() {
        return p.size();
    }

    @Override
	public final Processor getElementAt(final int index) {
        return p.get(index);
    }
}