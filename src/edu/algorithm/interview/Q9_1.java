package edu.algorithm.interview;


public class Q9_1
{
    public static int countHops(int n)
    {
        if (n < 0)
        {
            return 0;
        }
        else if (0 == n)
        {
            return 1;
        }
        else
        {
            return countHops(n - 1) + countHops(n - 2) + countHops(n - 3);
        }
    }
    
    // Dynamic Programming.
    public static int countHopsDP(int n)
    {
        int[] cache = new int[n + 1];
        return count(n, cache);
    }
    
    private static int count(int n, int[] cache)
    {
        if (n < 0)
        {
            return 0;
        }
        else if (0 == n)
        {
            return 1;
        }
        else if (0 != cache[n])
        {
            return cache[n];
        }
        else
        {
            cache[n] = count(n - 1, cache) + count(n - 2, cache) + count(n - 3, cache);
            return cache[n];
        }
    }
    
    public static void main(String[] args)
    {
        long begin = System.currentTimeMillis();
        int c = countHopsDP(4); // overflow
        long end = System.currentTimeMillis();
        System.out.println("Count= " + c + ", Time: " + (end - begin) + "ms");
        
//        begin = System.currentTimeMillis();
//        c = countHops(33);
//        end = System.currentTimeMillis();
//        System.out.println("Count= " + c + ", Time: " + (end - begin) + "ms");
    }
}
