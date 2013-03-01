package edu.algorithm.interview;

import java.util.Arrays;
import java.util.Scanner;

public class TopFour
{
    public static void topFour(int[] A)
    {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++)
        {
            if (A[i] >= max1)
            {
                max4 = max3;
                max3 = max2;
                max2 = max1;
                max1 = A[i];
            }

            else if (A[i] >= max2)
            {
                max4 = max3;
                max3 = max2;
                max2 = A[i];
            }

            else if (A[i] >= max3)
            {
                max4 = max3;
                max3 = A[i];
            }

            else if (A[i] >= max4)
            {
                max4 = A[i];
            }
        }

        if (A.length >= 1)
        {
            System.out.println(max1);
        }
        if (A.length >= 2)
        {
            System.out.println(max2);
        }
        if (A.length >= 3)
        {
            System.out.println(max3);
        }
        if (A.length >= 4)
        {
            System.out.println(max4);
        }
    }

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
            A[(subHigh + subLow) / 2] = temp;
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

    public static void selection(int[] A, int low, int high, int k)
    {
        if (low == high)
        {
            return;
        }
        int q = partition(A, low, high, findMedian(A, low, high));
        int rank = q - low + 1;
        if (rank == k)
        {
            return;
        }
        else if (rank > k)
        {
            selection(A, low, q - 1, k);
        }
        else
        {
            selection(A, q + 1, high, k - rank);
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
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        if (0 == N)
        {
            scan.close();
            return;
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
        {
            arr[i] = scan.nextInt();
        }
//        topFour(arr);
        selection(arr, 0, arr.length - 1, 4);
        Arrays.sort(arr, arr.length - 4, arr.length);
        for (int i = arr.length - 1; i >= arr.length - 4; i--)
        {
            System.out.println(arr[i]);
        }
        scan.close();
    }
}
