package edu.algorithm.search.algostrategy;

/**
 * 
 * @author jasonleakey
 * @date Apr 7, 2012
 * 
 */
public interface SearchStrategy
{
    public <T extends Comparable<? super T>> int search(T[] arr, int start,
            int end, T key);

}
