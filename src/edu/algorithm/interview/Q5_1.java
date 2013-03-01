package edu.algorithm.interview;

public class Q5_1
{
    public static int insert(int M, int N, int j, int i)
    {
        // clean bits. from j to i
        int mask = ~(((int) Math.pow(2, j - i + 2) - 1) << i);
        N &= mask;
        // move M to [j, i]
        M <<= i;
        // merge them.
        return N | M;
    }
    
    public static void main(String[] args)
    {
        int N = 0b10000000000;
        int M = 0b10011;
        int i = 2;
        int j = 6;
        System.out.println(Integer.toBinaryString(insert(M, N, j, i)));
    }
}
