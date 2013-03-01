package edu.algorithm.acm;

import java.util.HashSet;

import edu.algorithm.utils.ArraysTool;

/**
 * 测试数组中是否存在两个相同元素。
 * 
 * @author jasonleakey
 *
 */
public class DuplicateElemTest
{
    /**
     * 使用双循环比较。时间复杂度O(n^2)
     * @param arr
     * @return
     */
    public static boolean checkDuplicate_1(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] == arr[j])
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 使用Hashset方法。O(n)
     * @param arr
     * @return
     */
    public static boolean checkDuplicate_2(int[] arr)
    {
        Integer[] arr2 = new Integer[arr.length];
        // INIT a hashset
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0, len = arr.length; i < len; i++)
        {
            arr2[i] = arr[i];
            if (set.contains(arr2[i]))
            {
                return false;
            }
            else
            {
                set.add(arr2[i]);
            }
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        int[] arr_dup = ArraysTool.getNoDupIntArray(8, -30, 90);
        int[] arr_nodup = ArraysTool.getIntArray(8, -30, 90);
        
        ArraysTool.disp(arr_dup);
        ArraysTool.disp(arr_nodup);
//        System.out.println(DuplicateElemTest.checkDuplicate_1(arr_dup));
//        System.out.println(DuplicateElemTest.checkDuplicate_1(arr_nodup));
        System.out.println(DuplicateElemTest.checkDuplicate_2(arr_dup));
        System.out.println(DuplicateElemTest.checkDuplicate_2(arr_nodup));
    }
}
