package edu.algorithm.sort.algostrategy;

/**
 * 堆排序。
 * @author jasonleakey
 *
 */
public class HeapSort implements SortStrategy
{
    private int mStart; 
    private int mEnd;
    /**
     * 数组起始下标为0，计算子树下标时需要注意。
     */
    @Override
    public <T extends Comparable<? super T>> void sort(T[] arr, int start,
            int end)
    {
        this.mStart = start;
        this.mEnd = end;
        
        // 建大顶堆
        for (int i = parent(end); i >= start; i--)
        {
            maxHeapify(arr, i, end);
        }
        
        for (int i = end; i > start; i--)
        {
            // 交换堆顶与数组最后一顶
            T temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
            
            maxHeapify(arr, start, i - 1);
        }
    }
    
    /**
     * 建大顶堆
     * @param arr 数组
     * @param root 大顶堆的根结点
     */
    private <T extends Comparable<? super T>> void maxHeapify(T[] arr, int root, int end)
    {
        T rootVal = arr[root];
        // 逐级往下
        for (int j = left(root); j <= end; j = left(j))
        {
            // 左树 小于 右树。
            if (j + 1 <= end && arr[j + 1].compareTo(arr[j]) > 0)
            {
                j++;
            }
            
            // 如果root 已经找到插入的位置。
            if (rootVal.compareTo(arr[j]) > 0)
            {
                break;
            }
            
            arr[root] = arr[j];
            root = j;
        }
        
        arr[root] = rootVal;
    }

    /**
     * 用final字段模拟类似于C++的内联函数。
     * 求父结点的下标。公式为parent = (m-1)/2 
     */
    private final int parent(int node)
    {
        return (node + mStart - 1) / 2;
    }
    
    /**
     * 求左子树的下标。
     */
    private final int left(int node)
    {
        return 2 * node - mStart + 1;
    }
    
    /**
     * 求右子树的下标。
     */
    private final int right(int node)
    {
        return 2 * node - mStart + 2;
    }
}
