package eesa.gui.lists;

import com.whiuk.philip.eesa.core.Test;
import com.whiuk.philip.eesa.core.TestList;

/**
 * Provides a {@link javax.swing.ListModel}
 * implementation to show the list of tests.
 * @author Philip
 */
public class TestListModel extends javax.swing.AbstractListModel<Test>  {
    /**
        * 
        */
    private static final long serialVersionUID = 1L;
    /**
        * 
        */
    private final TestList testlist;

    /**
        * 
        * @param t test list
        */
    public TestListModel(final TestList t) {
        this.testlist = t;
    }

    @Override
	public final int getSize() {
        return testlist.numberOfTests();
    }
    @Override
	public final Test getElementAt(final int index) {
        return testlist.getTest(index);
    }
}
