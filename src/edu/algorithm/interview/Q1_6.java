package edu.algorithm.interview;

public class Q1_6
{
    public static void clockwiseRotate(int[][] mat)
    {
        // the size of NxN matrix
        int N = mat.length;
        
        for (int i = 0; i < N / 2; i++)
        {
            int B = N - i - 1;
            for (int j = i; j < B; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[B - j + i][i];
                mat[B - j + i][i] = mat[B][B - j + i];
                mat[B][B - j + i] = mat[j][B];
                mat[j][B] = temp;
            }
        }
    }
    
    public static void counterclockRotate(int[][] mat)
    {
        // the size of NxN matrix
        int N = mat.length;
        
        for (int i = 0; i < N / 2; i++)
        {
            int B = N - i - 1;
            for (int j = i; j < B; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[j][B];
                mat[j][B] = mat[B][B - j + i];
                mat[B][B - j + i] = mat[B - j + i][i];
                mat[B - j + i][i] = temp;
            }
        }
    }
    
    public static void Rotate180(int[][] mat)
    {
        // the size of NxN matrix
        int N = mat.length;
        
        for (int i = 0; i < N / 2; i++)
        {
            int B = N - i - 1;
            for (int j = i; j < B; j++)
            {
                int temp = mat[i][j];
                mat[i][j] = mat[B][B - j + i];
                mat[B][B - j + i] = temp;
                
                
                temp = mat[j][B];
                mat[j][B] = mat[B - j + i][i];
                mat[B - j + i][i] = temp;
            }
        }
    }
    
    public static void disp(int[][] mat)
    {
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat.length; j++)
            {
                System.out.print(String.valueOf(mat[i][j]) + '\t');
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        int[][] a = {{1, 2, 3, 4, 5, 6}, 
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}, 
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}};
        disp(a);
        System.out.println();
        
//        clockwiseRotate(a);
//        counterclockRotate(a);
        Rotate180(a);
        disp(a);
    }
}
