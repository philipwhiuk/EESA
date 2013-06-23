package eesa.event;

import eesa.core.Test;

/**
 * Provides information about changes to a test.
 * @author Philip
 */
public class TestEvent extends EventObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 
     */
    private final int first;
    /**
     * 
     */
    private final int last;
    /**
     * 
     * @param t test
     * @param f The index of the first affected test
     * @param l The index of the last affected test
     */
    public TestEvent(final Test t, final int f, final int l) {
        super(t);
        this.first = f;
        this.last = l;
    }
    /**
     * 
     * @return First affected
     */
    public final int getFirst() {
        return first;
    }
    /**
     * 
     * @return Last affected
     */
    public final int getLast() {
        return last;
    }
}
