package edu.algorithm.interview;

public class Q1_8
{
    public static boolean isRotation(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        
        // concatenate 
        String s11 = s1 + s1;
        return s11.contains(s2);
    }

    public static void main(String[] args)
    {
        System.out.println(isRotation("waterbottle", "aterbottlew"));
    }
}
