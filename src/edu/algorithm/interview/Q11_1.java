package edu.algorithm.interview;

public class Q11_1
{
    // DEFINE three pointers pa, pb, pc, pointing to the ends of three arrays,
    // respectively
    // FOR each element pair
    // ---// COMPAR A and B
    // ---// PUT the larger one to the end
    // ---// MOVE the pointer.
    // IF there are still elements left in B
    // COPY them to A.
    public static void mergeAndSort(int A[], int B[], int pa, int pb)
    {
        int pc = pa + pb + 1;

        while (pa >= 0 && pb >= 0)
        {
            if (A[pa] >= B[pb])
            {
                A[pc--] = A[pa--];
            }
            else
            {
                A[pc--] = B[pb--];
            }
        }

        if (pa < 0)
        {
            while (pb >= 0)
            {
                A[pc--] = B[pb--];
            }
        }
    }

    public static void main(String[] args)
    {
        int[] A = new int[20];
        A[0] = -4;
        A[1] = -1;
        A[2] = 2;
        A[3] = 3;
        A[4] = 5;
        A[5] = 8;
        A[6] = 9;
        int[] B = new int[] { -3, -3, 0, 4, 9 };
        mergeAndSort(A, B, 6, 4);
        for (int a : A)
        {
            System.out.print(String.valueOf(a) + "  ");
        }
        System.out.println();
    }
}
