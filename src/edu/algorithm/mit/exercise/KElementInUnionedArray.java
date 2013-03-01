package edu.algorithm.mit.exercise;

public class KElementInUnionedArray
{
    public static int kElem(int[] A, int[] B, int k)
    {
        if (k <= 0 || k > A.length + B.length)
        {
            throw new ArrayIndexOutOfBoundsException("invlid k!");
        }
        return kElem(A, B, k, 0, A.length - 1, 0, B.length - 1);
    }

    private static int kElem(int[] A, int[] B, int k, int low_A, int high_A,
            int low_B, int high_B)
    {
        if (low_A <= high_A && low_B <= high_B)
        {
            int mid_A = (low_A + high_A) / 2;
            int mid_B = (low_B + high_B) / 2;
            int a = mid_A - low_A + 1;
            int b = mid_B - low_B + 1;
            if (a + b > k)
            {
                if (A[mid_A] > B[mid_B])
                {
                    return kElem(A, B, k, low_A, mid_A - 1, low_B, high_B);
                }
                else
                {
                    return kElem(A, B, k, low_A, high_A, low_B, mid_B - 1);
                }
            }
            else if (A[mid_A] < B[mid_B])
            {
                return kElem(A, B, k - a, mid_A + 1, high_A, low_B, high_B);
            }
            else
            {
                return kElem(A, B, k - b, low_A, high_A, mid_B + 1, high_B);
            }
        }
        
        if (low_A <= high_A)
        {
            return A[low_A + k - 1];
        }
        else
        {
            return B[low_B + k - 1];
        }
    }
    
    public static int kElem2(int[] A, int [] B, int k)
    {
        return kElem2(A, 0, B, 0, k - 1);
    }
    
    private static int kElem2(int[] A, int I_A, int[] B, int I_B, int k)
    {
        if (1 == k)
        {
            int a = Math.min(A[I_A], A[I_A + 1]);
            int b = Math.min(B[I_B], B[I_B + 1]);
            return Math.max(a, b);
        }
        
        int M_A = A[I_A + (int) Math.floor(k / 2)];
        int M_B = B[I_B + (int) Math.floor(k / 2)];
        
        if (M_A < M_B)
        {
            return kElem2(A, I_A + (int) Math.floor(k / 2), B, I_B, (int) Math.ceil(k / 2));
        }
        else
        {
            return kElem2(A, I_A, B, I_B + (int) Math.floor(k / 2), (int) Math.ceil(k / 2));
        }
    }

    public static void main(String[] args)
    {
        int[] A = new int[] { 3, 4, 6, 8, 9, 10, 12, 14, 17, 20 };
        int[] B = new int[] { 1, 2, 4, 4, 7, 7, 7, 9, 10, 15};

//        for (int i = 1; i < A.length + B.length + 2; i++)
//        {
            System.out.println(kElem(A, B, A.length + B.length));
//        }
    }
}
