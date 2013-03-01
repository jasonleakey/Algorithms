package edu.algorithm.utils;

import java.lang.reflect.Array;
import java.util.Random;

public class ArraysTool
{
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T extends Comparable<? super T>> T[] createArray(Class a,
            int len)
    {
        return (T[]) Array.newInstance(a.getComponentType(), len);
    }

    public static void disp(int[] arr)
    {
        for (int a : arr)
        {
            System.out.print(a + "  ");
        }
        System.out.println();
    }

    /**
     * 随机产生整数数组
     * 
     * @param size
     *            数组大小
     * @param range_from
     *            数组最小值
     * @param range_to
     *            数组最大值
     * @return int格式整型数组
     */
    public static int[] getIntArray(int size, int range_from, int range_to)
    {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
        {
            arr[i] = (int) (Math.random() * (range_to - range_from) + range_from);
        }

        return arr;
    }

    /**
     * 随机产生整型数组，
     * 
     * @param size
     *            数组大小
     * @param range_from
     *            数组最小边界
     * @param range_to
     *            数组最大边界
     * @return Integer格式整型数组
     */
    public static Integer[] getIntegerArray(int size, int range_from,
            int range_to)
    {
        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++)
        {
            arr[i] = Integer.valueOf((int) (Math.random()
                    * (range_to - range_from) + range_from));
        }

        return arr;
    }
    
    /**
     * 寻找数组最大值
     * @param arr 数组
     * @return 最大值
     */
    public static int max(int[] arr)
    {
        int max = Integer.MIN_VALUE; 
        for (int a : arr)
        {
            if (a > max)
            {
                max = a;
            }
        }
        
        return max;
    }

    /**
     * 寻找数组最小值
     * @param arr 
     * @return
     */
    public static int min(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        for (int a : arr)
        {
            if (a < min)
            {
                min = a;
            }
        }
        
        return min;
    }
    /**
     * 生成不重复的整型数组
     * 
     * @param size
     *            数组大小
     * @param range_from
     *            数组最小值，inclusive
     * @param range_to
     *            数组最大值，inclusive
     * @return 不重复的整型数组
     * @throws IllegalArgumentException
     *             数组大小大于数组范围，无法生成数组。
     */
    public static int[]
            getNoDupIntArray(int size, int range_from, int range_to)
                    throws IllegalArgumentException
    {
        // 取值范围
        int range = range_to - range_from + 1;

        if (size > range)
        {
            throw new IllegalArgumentException();
        }

        // 结果数组
        int[] arr = new int[size];
        // 元素库，结果数组中的值都从此库中取出。
        int[] allNum = new int[range];
        for (int i = 0; i < range; i++)
        {
            allNum[i] = range_from + i;
        }
        // 随机数
        Random rd = new Random();

        for (int i = 0; i < size; i++)
        {
            // 从库中随机取出一个数
            int idx = rd.nextInt(range - i);
            arr[i] = allNum[idx];

            // 将库的最后一个数填补到已取出数的槽中，库的大小减一。
            allNum[idx] = allNum[range - i - 1];
        }

        return arr;
    }
}
