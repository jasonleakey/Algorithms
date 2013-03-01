package edu.algorithm.acm.zoj1001;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scaner = new Scanner(System.in);
        while (scaner.hasNextInt())
        {
            int a = scaner.nextInt();
            int b = scaner.nextInt();
            int c = a + b;
            System.out.println(c);
        }
    }
}
