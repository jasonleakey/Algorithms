package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q9_5
{
    public static List<String> perm(String A)
    {
        return perm(A, 0);
    }
    
    private static List<String> perm(String A, int index)
    {
        if (index < 0 || index >= A.length())
        {
            List<String> B = new ArrayList<String>();
            return B;
        }
        if (index == A.length() - 1)
        {
            List<String> B = new ArrayList<String>();
            B.add(String.valueOf(A.charAt(index)));
            return B;
        }
        List<String> B = perm(A, index + 1);
        Set<String> C = new HashSet<String>();
        for (String s : B)
        {
            for (int i = 0; i <= s.length(); i++)
            {
                StringBuilder t = new StringBuilder(s);
                t.insert(i, A.charAt(index));
                String s2 = t.toString();
                if (!C.contains(s2))
                {
                    C.add(s2);
                }
            }
        }
        return new ArrayList<String>(C);
    }
    
    public static void main(String[] args)
    {
        String A = "abcdab";
        List<String> B = perm(A);
        System.out.println("size: " + B.size() + "\n" + B);
    }
}
