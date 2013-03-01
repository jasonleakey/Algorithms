package edu.algorithm.interview;

public class Q9_3
{
    public static int magicIndex(int[] A)
    {
        return magicIndex(A, 0, A.length - 1);
    }

    private static int magicIndex(int[] A, int low, int high)
    {
        if (low < 0 || high >= A.length || low > high)
        {
            return -1;
        }
        
        int mid = (low + high) / 2;
        if (A[mid] == mid)
        {
            return mid;
        }
        // search right
        int result = magicIndex(A, Math.max(mid + 1, A[mid]), high);
        if (result >= 0)
        {
            return result;
        }
        
        // search left
        result = magicIndex(A, low, Math.min(mid - 1, A[mid]));
        return result;
    }

    public static void main(String[] args)
    {
        int[] A = new int[] { -3, -1, 0, 1, 2, 5, 6, 8, 9 };
        System.out.println(magicIndex(A));
    }
}
