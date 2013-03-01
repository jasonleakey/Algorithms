package edu.algorithm.sort.algostrategy;


/**
 * 搜索接口。
 * @author jasonleakey
 * @date Apr 7, 2012
 * 
 */
public interface SortStrategy
{
    public <T extends Comparable<? super T>> void sort(T[] arr, int start,
            int end);
}
