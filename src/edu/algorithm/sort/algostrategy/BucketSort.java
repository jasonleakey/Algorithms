package edu.algorithm.sort.algostrategy;

import edu.algorithm.utils.ArraysTool;

/**
 * 桶排序的思想是把[0，1)划分为n个大小相同的子区间，每一子区间是一个桶。
 * 然后将n个记录分配到各个桶中。因为关键字序列是均匀分布在[0，1)上的，
 * 所以一般不会有很多个记录落入同一个桶中
 * 。由于同一桶中的记录其关键字不尽相同，所以必须采用关键字比较的排序方法(通常用插入排序)
 * 对各个桶进行排序，然后依次将各非空桶中的记录连接(收集)起来即可。
 * 
 * @author jasonleakey
 */
public class BucketSort
{
    // 桶大小。
    private int bucketNum = 11;

    // 桶类
    private class Bucket
    {
        // 桶数组
        int[] data = null;
        // 桶内元素的数量。
        int size = 0;
    }

    public void sort(int[] arr)
    {
        // 分配若干个桶。
        Bucket[] buckets = new Bucket[bucketNum];
        // 找数组最值，用于算每个桶的范围。
        int maxValue = ArraysTool.max(arr);
        int minValue = ArraysTool.min(arr);

        for (int i = 0; i < arr.length; i++)
        {
            // 计算第i个元素放至在第idx个桶中。
            int idx = (int) (((float) arr[i] - minValue)
                    / (maxValue - minValue) * 100)
                    / (bucketNum + 1);
            // 初始化桶。
            if (null == buckets[idx])
            {
                buckets[idx] = new Bucket();
                buckets[idx].data = new int[arr.length];
            }

            // 寻找播入点，插入桶中
            int point = buckets[idx].size - 1;
            for (; point >= 0 && buckets[idx].data[point] > arr[i]; point--)
            {
                buckets[idx].data[point + 1] = buckets[idx].data[point];
            }
            buckets[idx].data[point + 1] = arr[i];
            buckets[idx].size++;
        }

        // 回收桶。
        int k = 0;
        for (int i = 0; i < bucketNum; i++)
        {
            if (null != buckets[i])
            {
                for (int j = 0; j < buckets[i].size; j++)
                {
                    arr[k++] = buckets[i].data[j];
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int arr[] = ArraysTool.getIntArray(10, 5, 30);
        ArraysTool.disp(arr);
        new BucketSort().sort(arr);
        ArraysTool.disp(arr);
    }
}
