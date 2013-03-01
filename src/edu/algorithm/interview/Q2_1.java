package edu.algorithm.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Q2_1
{
    public static void delDup(LinkedList L)
    {
        HashMap<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < L.size(); i++)
        {
            Object a = L.get(i);
            if (map.containsKey(a))
            {
                L.remove(i);
                i--;
            }
            else
            {
                map.put(a, i);
            }
        }
    }
    
    public static void delDup2(LinkedList L)
    {
        for (int i = 0; i < L.size() - 1; i++)
        {
            for (int j = i + 1; j < L.size(); j++)
            {
                if (L.get(j).equals(L.get(i)))
                {
                    L.remove(j);
                    j--;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        LinkedList L = new LinkedList(Arrays.asList("b", "c", "d",
                "h", "c", "c", "e", "u", "p", "p", "t", "j", "a", "x", "c"));
        System.out.println(L);
        
        System.out.println();
        
//        delDup(L);
        delDup2(L);
        System.out.println(L);
    }

}
