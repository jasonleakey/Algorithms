package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence
{
    public static void main(String[] args)
    {
        int[] arr = new int[] { 5, 1, 9, 1, 3, 3, 5, 4, 2, 7, 8, 5, 9 };
        int[] len = new int[arr.length];
        List<List<Integer>> subseqs = new ArrayList<List<Integer>>();
        for (int i = 0; i < arr.length; i++)
        {
            len[i] = 1;
            List<Integer> subseq = new ArrayList<Integer>();
            for (int j = 0; j < i; j++)
            {
                if (arr[j] < arr[i] && len[j] + 1 > len[i])
                {
                    len[i] = len[j] + 1;
                    subseq.clear();
                    subseq.addAll(subseqs.get(j));
                }
            }
            subseq.add(arr[i]);
            subseqs.add(subseq);
        }
        System.out.print("Longest(ending with A[i]):");
        int max = 0;
        for (int i = 0; i < len.length; i++)
        {
            System.out.print(len[i] + ",");
            if (len[i] > len[max])
            {
                max = i;
            }
        }
        System.out.println();
        System.out.println(subseqs);
        System.out.println("LIS: " + subseqs.get(max));
    }
}
