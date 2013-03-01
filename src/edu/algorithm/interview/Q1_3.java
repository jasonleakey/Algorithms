package edu.algorithm.interview;

import java.util.HashMap;
import java.util.Map;

public class Q1_3
{
    public static boolean IsPerm(String a, String b)
    {
        if (a.length() != b.length())
        {
            return false;
        }
        
        Map<Character, Integer> h = new HashMap<>();
        for (Character c : a.toCharArray())
        {
            if (h.containsKey(c))
            {
                Integer t = h.get(c);
                t++;
            }
            else
            {
                h.put(c, 1);
            }
        }
        
        for (Character c : b.toCharArray())
        {
            if (h.containsKey(c))
            {
                Integer t = h.get(c);
                if (t > 1)
                {
                    t--;
                }
                else
                {
                    h.remove(c);
                }
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean IsPerm2(String a, String b)
    {
        if (a.length() != b.length())
        {
            return false;
        }   
        
        int[] h = new int[256];
        for (char c : a.toCharArray())
        {
            h[c]++;
        }
        
        for (char c : b.toCharArray())
        {
            h[c]--;
            if (h[c] < 0)
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args)
    {
        String a = "kx1863na.jpq";
        String b = "p1863na.kxjq";
        System.out.println(IsPerm2(a, b));
    }
}

