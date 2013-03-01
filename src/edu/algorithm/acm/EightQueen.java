package edu.algorithm.acm;

public class EightQueen
{
    // The number of solutions
    private int sol_no = 0;

    public int getSolNo()
    {
        return sol_no;
    }

    // Core recursive algorithm to put queens. 
    public void solveEightQueen(String[][] grid, int col)
            throws InterruptedException
    {
        // if all columns have been put a queen in. 
        // then output this solution.
        if (col == grid.length)
        {
            // print solution
            printGrid(grid);
            // add 1 solution 
            sol_no++;
            
            return;
        }

        // all the number of choices that can be made is the number of recursive
        // calls.
        for (int row = 0; row < grid.length; row++)
        {
            // find a new position for queen.
            if (isValidPos(grid, row, col))
            {
                // put a queen here. 
                grid[row][col] = "*";
                
                // then put queens in the column. 
                solveEightQueen(grid, col + 1);
                
                // no matter success or failure for the step above, 
                // clear the queen in this location. 
                // try next row. 
                grid[row][col] = null;
            }
        }
    }

    private void printGrid(String[][] grid)
    {
        System.out.println("");
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid.length; j++)
            {
                if (null == grid[i][j])
                {
                    System.out.print(" " + "0");
                }
                else
                {
                    System.out.print(" " + grid[i][j]);
                }
            }
            System.out.println("");
        }
    }

    private static boolean isValidPos(String[][] grid, int row, int col)
    {
        // check for same column attack
        for (int i = row; i >= 0; i--)
        {
            if ("*".equals(grid[i][col]))
            {
                return false;
            }
        }
        // check for same row attack
        for (int i = col; i >= 0; i--)
        {
            if ("*".equals(grid[row][i]))
            {
                return false;
            }
        }

        /* check for up, left diagonal */
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if ("*".equals(grid[i][j]))
            {
                return false;
            }
        }

        /* check for down, left diagonal */
        for (int i = row, j = col; i < grid.length && j >= 0; i++, j--)
        {
            if ("*".equals(grid[i][j]))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String argv[]) throws InterruptedException
    {
        // eight queens
        int noOfQueens = 8;
        String[][] grid = new String[noOfQueens][noOfQueens];

        EightQueen eq = new EightQueen();

        eq.solveEightQueen(grid, 0);

        System.out.println(0 == eq.getSolNo() ? "No solution!" : ("Total "
                + eq.getSolNo() + " solutions."));
    }
}