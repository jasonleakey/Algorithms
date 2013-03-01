package edu.algorithm.sort.algostrategy;

import edu.algorithm.utils.ArraysTool;

/**
 * 鸽巢排序。Algorithm complexity O(N+n).
 * 1. Given an array of values to be sorted, set up an auxiliary array of
 * initially empty "pigeonholes," one pigeonhole for each key through the range
 * of the original array.
 * 2. Going over the original array, put each value into the pigeonhole
 * corresponding to its key, such that each pigeonhole eventually contains a
 * list of all values with that key.
 * 3. Iterate over the pigeonhole array in order, and put elements from
 * non-empty pigeonholes back into the original array.
 * 
 * @author jasonleakey
 */
public class PigeonholeSort 
{
    public void sort(int[] arr)
    {
        // pigeonhole 设置为256个。缺点是需要一个size至少等于待排序数组取值范围的缓冲区，不适合int等大范围数据。
        int[] b = new int[256];
        // pigeon +1
        for (int i = 0; i < arr.length; i++)
        {
            b[arr[i]]++;
        }
        
        int k = 0;
        // retrieve pigeon
        for (int i = 0; i < b.length; i++)
        {
            for (int j = 0; j < b[i]; j++)
            {
                arr[k++] = i;
            }
        }
    }

    public static void main(String[] args)
    {
        int arr[] = ArraysTool.getIntArray(20, 0, 26);
        new PigeonholeSort().sort(arr);
        ArraysTool.disp(arr);
    }
}
