package edu.algorithm.search.algostrategy;

/**
 * Binary Search
 * Q2.3-5
 * 
 * @author jasonleakey
 * 
 */
public class BinarySearch implements SearchStrategy
{
    private final static boolean isRecursive = true;

    @Override
    public <T extends Comparable<? super T>> int search(T[] arr, int start,
            int end, T key)
    {
        if (isRecursive)
        {
            return search_recursive(arr, start, end, key);
        }
        else
        {
            return search_iterative(arr, start, end, key);
        }
    }

    public <T extends Comparable<? super T>> int search_iterative(T[] arr,
            int start, int end, T key)
    {
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (arr[mid].compareTo(key) == 0)
            {
                return mid;
            }
            else if (arr[mid].compareTo(key) > 0)
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return -1;
    }

    // recursive version binary search
    public <T extends Comparable<? super T>> int search_recursive(T[] arr,
            int start, int end, T key)
    {
        if (start <= end)
        {
            int mid = (start + end) / 2;
            if (0 == arr[mid].compareTo(key))
            {
                return mid;
            }
            else if (arr[mid].compareTo(key) > 0)
            {
                return search_recursive(arr, start, mid - 1, key);
            }
            else
            {
                return search_recursive(arr, mid + 1, end, key);
            }
        }
        return -1;
    }
}
