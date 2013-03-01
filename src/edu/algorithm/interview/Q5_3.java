package edu.algorithm.interview;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class Q5_3
{
    public static int next(int num)
    {
        int start = 0;
        int end = 0;
        while (start < 31 && 0 == ((1 << start) & num))
        {
            start++;
        }
        
        if (start >= 32)
        {
            System.out.println("No next smallest number");
            return -1;
        }

        end = start;
        while (0 != ((1 << end) & num))
        {
            end++;
        }
        
        if (end >= 32)
        {
            System.out.println("No next smallest number");
            return -1;
        }

        num |= (1 << end);

        num &= (~((1 << end) - 1));
        num |= ((1 << (end - start - 1)) - 1);
        System.out.println("Next smallest number is " + BitOp.toString(num));
        return num;
    }
    
    public static int prev(int num)
    {
        int c0 = 0;
        int c1 = 0;
        int c = num;
        while (1 == (c & 1))
        {
            c1++;
            c >>= 1;
        }
        
        while (0 != c && 0 == (c & 1))
        {
            c0++;
            c >>= 1;
        }
        
        if (0 == c0 + c1)
        {
            System.out.println("No last largest number");
            return -1;
        }
        
        int p = c0 + c1;
        num &= ((~0) << (p + 1));
        num |= (((1 << (c1 + 1)) - 1) << (c0 - 1));
        System.out.println("Largest largest number is " + BitOp.toString(num));
        return num;
    }

    public static void main(String[] args)
    {
        int n = 0b1000010001110001111;
        System.out.println(BitOp.toString(n));
        next(n);
        prev(n);
    }
}
