package edu.algorithm.acm.zoj1295;

import java.util.Scanner;

public class Main
{
    private static String reverse(String str)
    {
        StringBuffer buf = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--)
        {
            buf.append(str.charAt(i));
        }
        return buf.toString();
    }

    public static void main(String[] args)
    {
        Scanner scaner = new Scanner(System.in);
        int noOfLine = scaner.nextInt();
        // eat the line break symbol.
        scaner.nextLine();

        for (int i = 0; i < noOfLine; i++)
        {
            String str = scaner.nextLine();
            System.out.println(Main.reverse(str));
        }

        scaner.close();
    }
}
