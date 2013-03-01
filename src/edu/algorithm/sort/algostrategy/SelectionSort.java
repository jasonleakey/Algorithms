package edu.algorithm.sort.algostrategy;

/**
 * 选择排序算法
 * 
 * 
 * @author jasonleakey
 * 
 */
public class SelectionSort implements SortStrategy
{
    public <T extends java.lang.Comparable<? super T>> void sort(T[] arr,
            int start, int end) 
    {
        // 选择排序，升序
        for (int i = start; i < end; i++)
        {
            // 从当前位置的下一位开始，查找最小值
            T min = arr[i];
            int minIdx = i;
            for (int j = i + 1; j <= end; j++)
            {
                if (arr[j].compareTo(min) < 0)
                {
                    min = arr[j];
                    minIdx = j;
                }
            }
            // 如果最小值不是当前位置，则交换位置。
            if (minIdx > i)
            {
                T tmp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
