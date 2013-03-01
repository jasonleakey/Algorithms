package edu.algorithm.interview;

import java.util.ArrayList;

public class Q5_7
{
    private static class BitInteger
    {
        int data;

        public BitInteger(int data)
        {
            this.data = data;
        }

        public int fetch(int digit)
        {
            return ((1 << digit) & data) == 0 ? 0 : 1;
        }
    }

    public static int findMissing(ArrayList<BitInteger> array)
    {
        return findMissing(array, 0);
    }

    private static int findMissing(ArrayList<BitInteger> input, int digit)
    {
        if (digit >= 32)
        {
            return 0;
        }

        ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(
                input.size() / 2);
        ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(
                input.size() / 2);

        for (BitInteger t : input)
        {
            if (0 == t.fetch(digit))
            {
                zeroBits.add(t);
            }
            else
            {
                oneBits.add(t);
            }
        }

        if (zeroBits.size() <= oneBits.size())
        {
            int v = findMissing(zeroBits, digit + 1);
            return (v << 1) | 0;
        }
        else
        {
            int v = findMissing(oneBits, digit + 1);
            return (v << 1) | 1;
        }
    }

    public static void main(String[] args)
    {
        ArrayList<BitInteger> arr = new ArrayList<BitInteger>();
        arr.add(new BitInteger(2));
        arr.add(new BitInteger(4));
        arr.add(new BitInteger(5));
        arr.add(new BitInteger(3));
        arr.add(new BitInteger(6));
        arr.add(new BitInteger(7));
        arr.add(new BitInteger(1));
        arr.add(new BitInteger(0));
        arr.add(new BitInteger(9));
        arr.add(new BitInteger(8));
        System.out.println("the missing number is " + findMissing(arr));

    }
}
