package edu.algorithm.mit.exercise;

import edu.algorithm.utils.ArraysTool;

public class PolyMultiply
{
    public static int[] multiply(int[] A, int B[])
    {
        int n = A.length;
        if (n <= 0 || A.length != B.length)
        {
            return null;
        }
        if (1 == n)
        {
            return new int[] { A[0] * B[0] };
        }

        int[] A0 = new int[n / 2];
        System.arraycopy(A, 0, A0, 0, n / 2);
        int[] A1 = new int[n - n / 2];
        System.arraycopy(A, n / 2, A1, 0, n - n / 2);
        int[] B0 = new int[n / 2];
        System.arraycopy(B, 0, B0, 0, n / 2);
        int[] B1 = new int[n - n / 2];
        System.arraycopy(B, n / 2, B1, 0, n - n / 2);

        int[] X = multiply(A0, B0);
        int[] Y = multiply(A1, B1);
        int[] Z = minus(minus(multiply(plus(A0, A1), plus(B0, B1)), X), Y);

        return plus(plus(X, shiftRight(Z, n / 2)), shiftRight(Y, 2 * (n / 2)));
    }

    public static int[] shiftRight(int[] T, int m)
    {
        int[] result = new int[T.length + m];
        for (int j = T.length - 1; j >= 0; j--)
        {
            result[j + m] = T[j];
        }

        return result;
    }

    private final static int[] plus(int[] U, int[] T)
    {
        int[] temp1 = null;
        int[] temp2 = null;
        int[] result = null;
        if (U.length > T.length)
        {
            temp1 = U;
            temp2 = new int[U.length];
            result = new int[U.length];
            System.arraycopy(T, 0, temp2, 0, T.length);
        }
        else if (U.length < T.length)
        {
            temp1 = new int[T.length];
            temp2 = T;
            result = new int[T.length];
            System.arraycopy(U, 0, temp1, 0, U.length);
        }
        else
        {
            temp1 = U;
            temp2 = T;
            result = new int[T.length];
        }

        for (int i = 0; i < temp1.length; i++)
        {
            result[i] = temp1[i] + temp2[i];
        }

        return result;
    }

    private final static int[] minus(int[] U, int[] T)
    {
        int[] temp1 = null;
        int[] temp2 = null;
        int[] result = null;
        if (U.length > T.length)
        {
            temp1 = U;
            temp2 = new int[U.length];
            result = new int[U.length];
            System.arraycopy(T, 0, temp2, 0, T.length);
        }
        else if (U.length < T.length)
        {
            temp1 = new int[T.length];
            temp2 = T;
            result = new int[T.length];
            System.arraycopy(U, 0, temp1, 0, U.length);
        }
        else
        {
            temp1 = U;
            temp2 = T;
            result = new int[T.length];
        }

        for (int i = 0; i < temp1.length; i++)
        {
            result[i] = temp1[i] - temp2[i];
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] A = { 8, 2, 3};
        int[] B = { 1, 2, 2};
        ArraysTool.disp(multiply(A, B));
    }

}
