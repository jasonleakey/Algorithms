package edu.algorithm.sort.algostrategy;

import edu.algorithm.search.algostrategy.BinarySearch;
import edu.algorithm.search.context.Searcher;

/**
 * Insertion Sort Including recursive method and iterative method
 * 
 * @author jasonleakey
 * 
 */
public class InsertSort implements SortStrategy
{
    private final static boolean isRecursive = false;
    private final static boolean isBinarySearch = false;

    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr, int start,
            int end)
    {
        if (isRecursive)
        {
            sort_recursive(arr, start, end);
        }
        else
        {
            if (isBinarySearch)
            {
                sort_iterative_binary(arr, start, end);
            }
            else
            {
                sort_iterative(arr, start, end);
            }
        }
    };

    // iterative version insert sort
    // O(n^2)
    public <T extends Comparable<? super T>> void sort_iterative(T[] arr,
            int start, int end)
    {
        // 插入排序，升序
        for (int i = start + 1; i <= end; i++)
        {
            if (arr[i].compareTo(arr[i - 1]) < 0)
            {
                T key = arr[i];
                int j = i - 1;
                for (; j >= start && arr[j].compareTo(key) > 0; j--)
                {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = key;
            }
        }
    }

    // Recursive version insert sort
    // Q2.3-4
    // O(n^2)
    public <T extends Comparable<? super T>> void sort_recursive(T[] arr,
            int start, int end)
    {
        if (end > start)
        {
            sort_recursive(arr, start, end - 1);
            if (arr[end].compareTo(arr[end - 1]) < 0)
            {
                T key = arr[end];
                int i = end - 1;
                for (; i >= start && arr[i].compareTo(key) > 0; i--)
                {
                    arr[i + 1] = arr[i];
                }
                arr[i + 1] = key;
            }
        }
    }

    // Use a binary search in insert sort algorithm
    // O(n lg n)
    public <T extends Comparable<? super T>> void sort_iterative_binary(
            T[] arr, int start, int end)
    {
        Searcher searcher = new Searcher(new BinarySearch());
        for (int i = start + 1; i <= end; i++)
        {
            if (arr[i].compareTo(arr[i - 1]) < 0)
            {
                T key = arr[i];
                int insertPoint = searcher.search(arr, start, i, key);
                int j = insertPoint;
                for (; j >= start && arr[j].compareTo(key) > 0; j--)
                {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = key;
            }
        }
    }

}
