package edu.algorithm.mit.exercise;

import java.util.Arrays;

import edu.algorithm.utils.ArraysTool;

public class FindMedian
{
    public static int findMedian(int[] A, int low, int high)
    {
        if (low == high)
        {
            return low;
        }

        int numMedians = (int) Math.ceil((double) (high - low + 1) / 5);
        for (int i = 0; i < numMedians; i++)
        {
            int subLow = low + 5 * i;
            int subHigh = Math.min(low + 5 * (i + 1) - 1, high);
            Arrays.sort(A, subLow, subHigh + 1);
            int temp = A[low + i];
            A[low + i] = A[(subLow + subHigh) / 2];
            A[(subHigh + subLow ) / 2] = temp;
        }

        return findMedian(A, low, low + numMedians - 1);
    }

    public static int partition(int[] A, int low, int high, int pivot)
    {
        int key = A[pivot];
        swap(A, pivot, high);
        pivot = low;
        for (int i = low; i < high; i++)
        {
            if (A[i] < key)
            {
                swap(A, i, pivot++);
            }
        }
        swap(A, high, pivot);
        return pivot;
    }

    public static int selection(int[] A, int low, int high, int k)
    {
        if (low == high)
        {
            return A[low];
        }
        int q = partition(A, low, high, findMedian(A, low, high));
        int rank = q - low + 1;
        if (rank == k)
        {
            return A[q];
        }
        else if (rank > k)
        {
            return selection(A, low, q - 1, k);
        }
        else
        {
            return selection(A, q + 1, high, k - rank);
        }
            
    }

    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] A = { 3, 5, 9, -1, 4, 2, 7, 6, -3, -5, -2, 8, -7, -6, -9, -10, 11, 10, 0, -8, -11, 1};
        System.out.println(selection(A, 0, A.length - 1, (int) Math.ceil((double) A.length / 2)));
        Arrays.sort(A);
        ArraysTool.disp(A);
    }
}
