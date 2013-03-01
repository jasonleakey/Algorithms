package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.HashSet;

public class Q9_6
{
    public static HashSet<String> getParens(int n)
    {
        if (0 == n)
        {
            HashSet<String> B = new HashSet<String>();
            B.add("");
            return B;
        }
        HashSet<String> A = getParens(n - 1);
        HashSet<String> B = new HashSet<String>();
        for (String s : A)
        {
            for (int i = 0; i <= s.length(); i++)
            {
                StringBuilder buf = new StringBuilder(s);
                buf.insert(i, "()");
                String t = buf.toString();
                B.add(t);
            }
        }
        return B;
    }
    
    public static ArrayList<String> getParens2(int count)
    {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }
    
    private static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count)
    {
        if (leftRem < 0 || rightRem < leftRem)
        {
            return;
        }
        
        if (0 == leftRem && 0 == rightRem)
        {
            String s = String.copyValueOf(str);
            list.add(s);
        }
        else
        {
            if (leftRem > 0)
            {
                // Backtrace 
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }
            
            if (rightRem > leftRem)
            {
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
            
    }

    public static void main(String[] args)
    {
        System.out.println(getParens2(3));
    }
}
