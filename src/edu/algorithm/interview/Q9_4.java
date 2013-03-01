package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q9_4
{
    // T: O(2^n); S: O(2^n)
    public static ArrayList<ArrayList<Integer>> subset(List<Integer> A)
    {
        if (null == A || A.isEmpty())
        {
            ArrayList<Integer> s = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
            b.add(s);
            return b;
        }
        Iterator<Integer> iter = A.iterator();
        Integer e = iter.next();
        // remove one element and run recursion.
        A.remove(e);
        ArrayList<ArrayList<Integer>> B = subset(A);
        ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
        C.addAll(B);
        for (ArrayList<Integer> s : B)
        {
            ArrayList<Integer> s2 = new ArrayList<Integer>();
            s2.addAll(s);
            s2.add(e);
            C.add(s2);
        }
        return C;
    }
    
    // Combinatorics 
    public static List<List<Integer>> subset2(List<Integer> A)
    {
        List<List<Integer>> B = new ArrayList<List<Integer>>();
        for (int k = 0; k < Math.pow(2, A.size()); k++)
        {
            List<Integer> s = new ArrayList<Integer>();
            for (int i = 0, j = k; j != 0; j >>= 1, i++)
            {
                if (1 == (j & 1))
                {
                    s.add(A.get(i));
                }
            }
            B.add(s);
        }
        return B;
    }
    
    public static void main(String[] args)
    {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(7);
        List B = subset2(A);
        System.out.println("size " + B.size() + ":  " + B);
    }
}
