package com.whiuk.philip.eesa.event;

/**
 * Provides the base event object structure for all EESA event objects.
 * @author Philip
 */
class EventObject extends java.util.EventObject {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param o source
     */
    EventObject(final Object o) {
        super(o);
    }
}
