package edu.algorithm.interview;

import java.util.Scanner;

public class Q5_5
{
    public static int convert(int A, int B)
    {
        int count = 0;
        while (A != 0 || B != 0)
        {
            if ((A & 1) != (B & 1))
            {
                count++;
            }
            A >>= 1;
            B >>= 1;
        }
        return count;
    }
    
    public static int convert2(int A, int B)
    {
        int count = 0;
        for (int C = A ^ B; C != 0; C >>= 1)
        {
            count += C & 1;
        }
        return count;
    }
    
    public static int convert3(int A, int B)
    {
        int count = 0;
        for (int C = A ^ B; C != 0; C &= (C - 1))
        {
            count++;
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        int A = 64;
        int B = 32;
        System.out.println("A= " + BitOp.toString(A));
        System.out.println("B= " + BitOp.toString(B));
        System.out.println(convert3(A, B));
    }
}
