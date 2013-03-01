package edu.algorithm.sort.context;

import edu.algorithm.sort.algostrategy.SortStrategy;

public class Sorter
{
    private SortStrategy mSortStrategy;
    private long mAlgoTime = 0;

    public Sorter(SortStrategy strategy)
    {
        this.mSortStrategy = strategy;
    }

    public SortStrategy getSortStrategy()
    {
        return mSortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy)
    {
        this.mSortStrategy = sortStrategy;
    }
    
    public void sort(int[] data)
    {
        sort(data, 0, data.length);
    }
    
    public void sort(float[] data)
    {
        sort(data, 0, data.length);
    }
    
    public void sort(int[] data, int from, int to)
    {
        // int转Integer
        Integer[] dataObj = new Integer[to - from];
        int i = 0;
        for (int a : data)
        {
            dataObj[i++] = Integer.valueOf(a);
        }
        // 排序
        sort(dataObj, from, to);
        
        // Integer转int
        i = 0;
        for (Integer a : dataObj)
        {
            data[i++] = a.intValue();
        }
    }
    
    public void sort(float[] data, int from, int to)
    {
        // float转Float
        Float[] dataObj = new Float[to - from];
        int i = 0;
        for (float a : data)
        {
            dataObj[i++] = Float.valueOf(a);
        }
        // 排序
        sort(dataObj, from, to);
        
        // Float转float
        i = 0;
        for (Float a : dataObj)
        {
            data[i++] = a.floatValue();
        }
    }

    public <T extends Comparable<? super T>> void sort(T[] data)
    {
        sort(data, 0, data.length);
    }

    public <T extends Comparable<? super T>> void sort(T[] data, int from,
            int to) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException, ClassCastException
    {
        if (from >= to)
        {
            throw new IllegalArgumentException("终止位置必须大于起始位置！");
        }

        long startTime = System.nanoTime();
        mSortStrategy.sort(data, from, to - 1);
        long endTime = System.nanoTime();
        mAlgoTime = endTime - startTime;
    }

    public String getAlgoTime()
    {
        return Float.toString((float) mAlgoTime/ 1000000) + "ms";
    }

}
