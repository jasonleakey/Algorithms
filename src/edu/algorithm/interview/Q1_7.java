package edu.algorithm.interview;

import java.util.HashSet;
import java.util.Set;

public class Q1_7
{
    public static void setZero(int[][] mat)
    {
        // MxN matrix
        int M = mat.length;
        int N = mat[0].length;
        
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        // FOR each row
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (0 == mat[i][j])
                {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
        for (int row : rowSet)
        {
            for (int j = 0; j < N; j++)
            {
                mat[row][j] = 0;
            }
        }
        
        for (int col : colSet)
        {
            for (int i = 0; i < M; i++)
            {
                mat[i][col] = 0;
            }
        }
    }
    
    
    
    public static void main(String[] args)
    {
        int[][] mat = {{9, 3, 0, 8, 7},
        {2, 9, 4, 5, 0},
        {8, 8, 9, 4, 8},
        {0, 3, 2, 6, 0},
        {6, 9, 7, 5, 3}};
        
        // use the display matrix function in Q1_6
        Q1_6.disp(mat);
        System.out.println();
        
        setZero(mat);
        
        Q1_6.disp(mat);
    }
}
