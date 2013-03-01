package edu.algorithm.sort.algostrategy;

import java.util.Arrays;

import edu.algorithm.utils.ArraysTool;

/**
 * 计数排序
 * the algorithm loops over the items,
 * computing a histogram of the number of
 * times each key occurs within the input collection.
 * It then performs a prefix sum computation
 * (a second loop, over the range of possible keys) to determine,
 * for each key, the starting position in the output array of the items having
 * that key.
 * Finally, it loops over the items again,
 * moving each item into its sorted position in the output array.
 * 
 * @author jasonleakey
 */
public class CountSort
{
    public int[] sort(int[] arr)
    {
        int[] output = new int[arr.length];
        int[] count = new int[26];

        // 计数数组清零
        Arrays.fill(count, 0);
        for (int i = 0; i < arr.length; i++)
        {
            count[arr[i]]++;
        }

        // 计数数组求和
        for (int i = 1; i < count.length; i++)
        {
            count[i] = count[i - 1] + count[i];
        }

        // 输出到结果中。
        for (int i = 0; i < arr.length; i++)
        {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return output;
    }

    public static void main(String[] args)
    {
        int arr[] = ArraysTool.getIntArray(20, 5, 26);
        ArraysTool.disp(arr);
        int out[] = new CountSort().sort(arr);
        ArraysTool.disp(out);
    }
}
