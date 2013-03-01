package edu.algorithm.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NextHighestInteger
{
    public static int next(int A)
    {
        if (A < 0)
        {
            return -1;
        }
        
        List<Integer> B = new LinkedList<Integer>();
        while (A > 0)
        {
            B.add(0, A % 10);
            A /= 10;
        }
        Integer[] C = B.toArray(new Integer[0]);
        int k = 0; 
        for (k = C.length - 2; k >= 0 && C[k] >= C[k + 1]; k--)
        {
            ;
        }
        
        if (k < 0)
        {
            return -1;
        }
        
        int temp = C[k];
        C[k] = C[C.length - 1];
        C[C.length - 1] = temp;
        
        Arrays.sort(C, k + 1, C.length);
        
        StringBuilder buf = new StringBuilder();
        for (Integer t : C)
        {
            buf.append(t);
        }
        
        return Integer.parseInt(buf.toString());
    }
    
    public static void main(String[] args)
    {
        System.out.println(next(102));
    }
}
