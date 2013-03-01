package edu.algorithm.search.context;

import edu.algorithm.search.algostrategy.SearchStrategy;

public class Searcher
{
    private SearchStrategy mSearchStrategy;
    private long mAlgoTime = 0;

    public Searcher(SearchStrategy strategy)
    {
        this.mSearchStrategy = strategy;
    }

    public SearchStrategy getSearchStrategy()
    {
        return mSearchStrategy;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy)
    {
        this.mSearchStrategy = searchStrategy;
    }

    public <T extends Comparable<? super T>> int search(T[] data, T key)
    {
        return search(data, 0, data.length, key);
    }

    public <T extends Comparable<? super T>> int search(T[] data, int from,
            int to, T key) throws IllegalArgumentException,
            ArrayIndexOutOfBoundsException, ClassCastException
    {
        if (from > to)
        {
            throw new IllegalArgumentException("终止位置必须大于起始位置！");
        }
        
        long startTime = System.currentTimeMillis();
        int result = mSearchStrategy.search(data, from, to - 1, key);
        long endTime = System.currentTimeMillis();
        mAlgoTime = endTime - startTime;

        return result;
    }

    public String getAlgoTime()
    {
        return Long.toString(mAlgoTime) + "ms";
    }

}
