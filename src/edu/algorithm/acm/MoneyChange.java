package edu.algorithm.acm;

/**
 * make n cents change with quarters, dimes, nickels, and pennies
 * and using the least total number of coins.
 * 
 * @author jasonleakey
 */
public class MoneyChange
{
    // values of denominations of coins
    private final static double[] COINS = { 0.25, 0.1, 0.05, 0.01 };

    public void change(double n)
    {
        System.out.println(n);

        for (double coin : COINS)
        {
            int count = 0;
            // 0.009 is the threshold
            while (n > coin || Math.abs(n - coin) < 0.009) 
            {
                // add a coin to the change.
                n -= coin;
                count++;
            }

            if (count != 0)
            {
                System.out.println(count + " " + coin);
            }
        }
    }

    public static void main(String[] args)
    {
        new MoneyChange().change(1.18);
    }
}
