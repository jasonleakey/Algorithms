package edu.algorithm.sort.algostrategy;

import edu.algorithm.utils.ArraysTool;


/**
 * Merge Sort Algorithm
 * 
 * @author jasonleakey
 * 
 */
public class MergeSort implements SortStrategy
{
    private final static boolean isUseSentinel = false;

    @Override
    public <T extends java.lang.Comparable<? super T>> void sort(T[] arr,
            int start, int end)
    {
        if (start < end)
        {
            // Divide
            int mid = (start + end) / 2;
            // Conquer
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            // Combine
            merge(arr, start, mid, end);
        }
    }

    // merge the sub-arrays of [r1...r2] and [r2+1...r3]
    private <T extends java.lang.Comparable<? super T>> void merge(T[] arr,
            int r1, int r2, int r3)
    {
        int len_A = r2 - r1 + 1;
        int len_B = r3 - r2;

        int i = 0;
        int j = 0;

        if (isUseSentinel)
        {
            T[] subarr_A = ArraysTool.createArray(arr.getClass(), len_A + 1);
            System.arraycopy(arr, r1, subarr_A, 0, len_A);
            T[] subarr_B = ArraysTool.createArray(arr.getClass(), len_B + 1);
            System.arraycopy(arr, r2 + 1, subarr_B, 0, len_B);
            
            // TODO: the sentinel here is set as the MAX VALUE of class type T
            
        }
        else
        {
            // create arrays
            T[] subarr_A = ArraysTool.createArray(arr.getClass(), len_A);
            System.arraycopy(arr, r1, subarr_A, 0, len_A);
            T[] subarr_B = ArraysTool.createArray(arr.getClass(), len_B);
            System.arraycopy(arr, r2 + 1, subarr_B, 0, len_B);
            
            // compare each element and then insert the small one to original
            // array.
            while (i < len_A && j < len_B)
            {
                if (subarr_A[i].compareTo(subarr_B[j]) < 0)
                {
                    arr[r1 + i + j] = subarr_A[i];
                    i++;
                }
                else
                {
                    arr[r1 + i + j] = subarr_B[j];
                    j++;
                }
            }

            // copy the remaining ones.
            if (i >= len_A)
            {
                System.arraycopy(subarr_B, j, arr, r1 + i + j, len_B - j);
            }
            else
            {
                System.arraycopy(subarr_A, i, arr, r1 + i + j, len_A - i);
            }
        }
    }
}
