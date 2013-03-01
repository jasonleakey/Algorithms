package edu.algorithm.interview;

public class Q1_1
{
    public static boolean IsUnique(char[] str)
    {
        if (str.length > 256)
        {
            return false;
        }
        
        int[] arr = new int[256];
        for (char c : str)
        {
            if (arr[c] == 1)
            {
                return false;
            }
            else
            {
                arr[c] = 1;
            }
        }
       
        return true;
    }
    
    
    public static void main(String[] args)
    {
        String test = "akb,zpq281.-`'ja]IB$)AY d";
        String test2 = "akb,zpq281";
        System.out.println(IsUnique(test.toCharArray()));
        System.out.println(IsUnique(test2.toCharArray()));
    }
}
