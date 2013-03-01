package edu.algorithm.interview;

public class Q7_4
{
    public static int multiply(int x, int y)
    {
        int sum = 0;
        int x1 = abs(x);
        int y1 = abs(y);
        for (int i = 0; i < x1; i++)
        {
            sum += y1;
        }
        if ((x > 0 && y < 0) || (x < 0 && y > 0))
        {
            sum = negate(sum);
        }
        return sum;
    }
    
    public static int subtract(int x, int y)
    {
        return x + negate(y);
    }
    
    public static int divide(int x, int y) throws ArithmeticException
    {
        if (0 == y)
        {
            throw new ArithmeticException("Cannot be divided by zero!");
        }
        int x1 = abs(x);
        int y1 = abs(y);
        int k = 0;
        int sum = y1;
        while (sum <= x1)
        {
            sum += y1;
            k++;
        }
        
        if ((x > 0 && y < 0) || (x < 0 && y > 0))
        {
            k = negate(k);
        }
        return k;
    }
    
    private static int negate(int a)
    {
        int sum = 0;
        int b = a > 0 ? -1 : 1;
        while (a != 0)
        {
            sum += b;
            a += b;
        }
        
        return sum;
    }
    
    private static final int abs(int a)
    {
        if (a < 0)
        {
            return negate(a);
        }
        else
        {
            return a;
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println("A*B=" + multiply(10, 3));
        System.out.println("A*B=" + subtract(10, 3));
        System.out.println("A/B=" + divide(-93, 0));
    }
}
