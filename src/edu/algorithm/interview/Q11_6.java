package edu.algorithm.interview;

public class Q11_6
{
    public static int[] dfs(int[][] mat, int target)
    {
        return find(mat, target, 0, 0);
    }

    private static int[] find(int[][] mat, int target, int row, int col)
    {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length)
        {
            return new int[] { -1, -1 };
        }

        if (mat[row][col] == target)
        {
            return new int[] { row, col };
        }

        int[] result = find(mat, target, row, col + 1);
        if (result[0] >= 0 && result[0] >= 0)
        {
            return result;
        }
        result = find(mat, target, row + 1, col);
        if (result[0] >= 0 && result[0] >= 0)
        {
            return result;
        }

        return new int[] { -1, -1 };
    }

    public static int[] findElement(int[][] mat, int target)
    {
        int row = 0;
        int col = mat[0].length - 1;
        while (row < mat.length && col >= 0)
        {
            if (mat[row][col] == target)
            {
                return new int[] { row, col };
            }
            else if (mat[row][col] > target)
            {
                col--;
            }
            else
            {
                row++;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args)
    {
        int[][] mat = new int[][] { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 },
                { 19, 20, 21, 22, 23, 24 } };
        int[] result = findElement(mat, 22); // dfs(mat, 22);
        System.out.println(result[0] + "," + result[1]);
    }
}
