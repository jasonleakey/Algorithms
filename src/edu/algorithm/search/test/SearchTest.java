package edu.algorithm.search.test;

import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.algorithm.search.algostrategy.BinarySearch;
import edu.algorithm.search.algostrategy.LinearSearch;
import edu.algorithm.search.context.Searcher;
import edu.algorithm.sort.algostrategy.MergeSort;
import edu.algorithm.sort.context.Sorter;

public class SearchTest extends TestCase
{
    Searcher searcher;
    Searcher binsearcher;
//    Integer[] arr = new Integer[] {1, 8, -9, 9, 2, -1, -2, 3, -7, 6, -8, -5, 4, 8};
    Integer[] arr = new Integer[] {15, 15, 15, 15, 15};

    @Before
    public void setUp() throws Exception
    {
        searcher = new Searcher(new LinearSearch());
        binsearcher = new Searcher(new BinarySearch());
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testLinearSearch()
    {
        int result = searcher.search(arr, -2);
        assertEquals(6, result);
    }

    @Test
    public void testBinarySearch()
    {
        new Sorter(new MergeSort()).sort(arr);
//        int result = binsearcher.search(arr, -2);
//        assertEquals(Arrays.binarySearch(arr, -2), result);
//        result = binsearcher.search(arr, -7);
//        assertEquals(Arrays.binarySearch(arr, -7), result);
        int result = binsearcher.search(arr, 15);
        assertEquals(Arrays.binarySearch(arr, 15), result);
    }
}
