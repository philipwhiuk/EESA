package com.whiuk.philip.eesa.algorithms.ssa;

import java.util.ArrayList;

/**
 *
 * @param <A>
 * @param <B>
 * @author Philip
 */
public class SegmentTree<A, B> {
	/**
	 * 
	 */
    private SegmentTree<A, B> leftNode;
    /**
     * 
     */
    private SegmentTree<A, B> rightNode;
    /**
     * 
     */
    private A leftLeaf;
    /**
     * 
     */
    private A rightLeaf;
    /**
     * 
     */
    private ArrayList<B> elements;
    
    /**
     * 
     * @param l Left node
     * @param r Right node
     * @param min Minimum
     * @param max Maximum
     * @param e Elements
     */
    public SegmentTree(final SegmentTree<A, B> l,
    		final SegmentTree<A, B> r,
    		final A min, final A max, final ArrayList<B> e) {
        this.leftNode = l;
        this.rightNode = r;
        this.leftLeaf = min;
        this.rightLeaf = max;
        this.elements = e;
    }
    /**
     * 
     * @param item The item
     */
    public void contains(final B item) {
        
    }
}
