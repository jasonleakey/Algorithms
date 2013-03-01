package edu.algorithm.sort.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.algorithm.sort.algostrategy.HeapSort;
import edu.algorithm.sort.algostrategy.InsertSort;
import edu.algorithm.sort.algostrategy.MergeSort;
import edu.algorithm.sort.algostrategy.SelectionSort;
import edu.algorithm.sort.algostrategy.SortStrategy;
import edu.algorithm.sort.context.Sorter;
import edu.algorithm.utils.ArraysTool;

public class SortTest extends TestCase
{
    private final static int[] orig_arr = ArraysTool.getIntArray(20, -5, 30);
    private int[] ans = new int[orig_arr.length];
    private int[] arr = new int[orig_arr.length];
    SortStrategy strate;
    Sorter sorter;

    @Before
    public void setUp() throws Exception
    {
        System.arraycopy(orig_arr, 0, arr, 0, orig_arr.length);
        System.arraycopy(orig_arr, 0, ans, 0, orig_arr.length);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testInsertSort()
    {
        strate = new InsertSort();
        sorter = new Sorter(strate);

        sorter.sort(arr);
        Arrays.sort(ans);

        printResult();
    }

    @Test
    public void testSelectionSort()
    {
        strate = new SelectionSort();
        sorter = new Sorter(strate);

        sorter.sort(arr);
        Arrays.sort(ans);
        
        printResult();
    }

    @Test
    public void testMergeSort()
    {
        strate = new MergeSort();
        sorter = new Sorter(strate);
        sorter.sort(arr);
        Arrays.sort(ans);
        
        printResult();
    }

    @Test
    public void testHeapSort()
    {
        strate = new HeapSort();
        sorter = new Sorter(strate);

        sorter.sort(arr);
        Arrays.sort(ans);
        
        printResult();
    }

    private void printResult()
    {
        System.out.print("耗费时间：" + sorter.getAlgoTime() + "\t");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
            System.out.print("  ");
        }
        System.out.println();
        assertArrayEquals(ans, arr);
    }
}
