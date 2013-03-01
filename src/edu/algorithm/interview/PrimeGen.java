package edu.algorithm.interview;

public class PrimeGen
{
    public static boolean[] sieveOfEratosthenes(int max)
    {
        boolean[] flags = new boolean[max + 1];

        int prime = 2;

        while (prime <= max)
        {
            // Cross off remaining multiples of prime
            crossOff(flags, prime);

            System.out.print(prime + ", ");
            // find next value which is true
            prime = getNextPrime(flags, prime);

            if (prime >= flags.length)
            {
                break;
            }
        }

        return flags;
    }

    private static void crossOff(boolean[] flags, int prime)
    {
        for (int i = prime * prime; i < flags.length; i += prime)
        {
            flags[i] = true;
        }
    }

    public static int getNextPrime(boolean[] flags, int prime)
    {
        int next = prime + 1;
        while (next < flags.length && flags[next])
        {
            next++;
        }
        return next;
    }

    public static void main(String[] args)
    {
        sieveOfEratosthenes(99);
    }
}
