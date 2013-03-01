/**
 * 
 */
package edu.algorithm.search.algostrategy;

/**
 * Linear Search
 * 
 * @author jasonleakey
 * 
 */
public class LinearSearch implements SearchStrategy
{
    @Override
    public  <T extends Comparable<? super T>> int search(T[] arr, int start,
            int end, T key) 
    {
        for (int i = start; i <= end; i++)
        {
            if (arr[i].compareTo(key) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }

}
