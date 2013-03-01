package edu.algorithm.mit.exercise;

import java.util.Arrays;

import edu.algorithm.utils.ArraysTool;

/**
 * 问题描述：判断数组中是否存在两个值之和为x
 * 算法要求：nlgn
 * 算法思想：先归并排序再二分法。
 * 
 * @author jasonleakey
 */
public class Q2_3_7
{
    public static boolean checkSum(int[] S, int x)
    {

        // Sorter sorter = new Sorter(new MergeSort());
        // Searcher searcher = new Searcher(new BinarySearch());
        // sorter.sort(S);
        Arrays.sort(S);
        for (int i = 0; i < S.length; i++)
        {
            // int j = searcher.search(S, i, S.length, x - S[i]);
            int j = Arrays.binarySearch(S, i, S.length, x - S[i]);
            if (j >= 0)
            {
                System.out.println("Integer 1: S[" + i + "]=" + S[i]);
                System.out.println("Integer 2: S[" + j + "]=" + S[j]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {

        // Integer[] S = new Integer[] {0, 9, 3, -2, 3, 8, -9, 1, -1, 2, -3, 4,
        // 7, 5, -6, 3, -2, 9, -5, -2};
        int[] S = ArraysTool.getIntArray(100, -50, 50);
        for (int i = 0; i < S.length; i++)
        {
            System.out.print(S[i] + "  ");
        }
        System.out.println();
        System.out.println(checkSum(S, 95));
    }
}
