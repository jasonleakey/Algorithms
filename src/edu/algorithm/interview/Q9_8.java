package edu.algorithm.interview;

public class Q9_8
{
    public static int cent(int n)
    {
        if (0 == n)
        {
            System.out.println();
            return 1;
        }
        
        int count = 0;
        if (n >= 25)
        {
            System.out.print("25+");
            count += cent(n - 25);
        }
        
        if (n >= 10)
        {
            System.out.print("10+");
            count += cent(n - 10);
        }
        
        if (n >= 5)
        {
            System.out.print("5+");
            count += cent(n - 5);
        }
        
        if (n >= 1)
        {
            System.out.print("11111+");
            count += 1;
        }
        
        return count;
    }
    
    public static int makeChange(int n, int denom)
    {
        int next_denom = 0;
        switch (denom)
        {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        
        int ways = 0;
        for (int i = 0; i * denom <= n; i++)
        {
            ways += makeChange(n - i * denom, next_denom);
        }
        return ways;
    }
    
    public static void main(String[] args)
    {
        System.out.println(makeChange(15, 25));
    }
}
