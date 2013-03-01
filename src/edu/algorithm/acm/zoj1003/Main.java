package edu.algorithm.acm.zoj1003;

import java.util.Scanner;

// REFERENCED ANSWER
public class Main
{
    public static boolean a_flag = false;

    public static boolean b_flag = false;

    // DFS factoring a and b
    // NOTICE: the method only works over b > a
    public static void dfs(int a, int b, int n)
    {
        // END CONDITION: all balloons are traversed
        // or both of a, b have been factored.
        if (n > 100 || (a_flag && b_flag))
        {
            return;
        }

        // mark two flags based on the value of a, b
        if (1 == a)
        {
            a_flag = true;
            // the bigger number b is successfully factorized only if
            // the smaller one a is already factorized.
            if (1 == b)
            {
                b_flag = true;
            }
        }

        // factorize a, b until both of them reach 1.
        if (0 == a % n)
        {
            dfs(a / n, b, n + 1);
        }

        if (0 == b % n)
        {
            dfs(a, b / n, n + 1);
        }

        dfs(a, b, n + 1);
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt())
        {
            int a = scan.nextInt();
            int b = scan.nextInt();

            Main.a_flag = false;
            Main.b_flag = false;
            if (a > b)
            {
                int temp = a;
                a = b;
                b = temp;
            }
            // start factor analysis with factor 2
            Main.dfs(a, b, 2);

            // the smaller number is factorized,
            // but the bigger number not.
            // that is, the smaller one challenges successfully.
            if (Main.a_flag && !Main.b_flag)
            {
                System.out.println(a);
            }
            // otherwise, the bigger one wins.
            else
            {
                System.out.println(b);
            }
        }
    }
}