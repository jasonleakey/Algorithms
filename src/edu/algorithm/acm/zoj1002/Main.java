package edu.algorithm.acm.zoj1002;

import java.util.Scanner;

public class Main
{
    // the maximum number of blockhouses
    private int maxBlock = 0;

    // the number of blockhouses for one solution
    private int noBlock = 0;

    public int getMaxBlock()
    {
        return maxBlock;
    }

    public Main()
    {
    }
    
    /*-
     * IF current col > the max column THEN
     *     IF the number of blockhouse in current city exceeds max blockhouse number THEN
     *         update the max blockhouse number
     *     END IF
     *     RETURN
     * END IF
     * 
     * calculate next position
     * IF current position is valid to put a blockhouse THEN
     *     put a blockhouse
     *     blockhouse number + 1
     *     
     *     recursively put blockhouse in next position.
     *     
     *     redraw the blockhouse put just now
     *     blockhouse number - 1
     * END IF
     * 
     * recursively put blockhouse in next position.
     */
    public void putBlockHouse(String[][] grid, int row, int col)
    {
        if (col == grid.length)
        {
            if (noBlock > maxBlock)
            {
                maxBlock = noBlock;
            }

            return;
        }

        int nextRow = (grid.length - 1) == row ? 0 : row + 1;
        int nextCol = (grid.length - 1) == row ? col + 1 : col;

        if (isValidPos(grid, row, col))
        {
            grid[row][col] = "+";
            noBlock++;

            putBlockHouse(grid, nextRow, nextCol);

            grid[row][col] = null;
            noBlock--;
        }

        putBlockHouse(grid, nextRow, nextCol);
    }

    private static boolean isValidPos(String[][] grid, int row, int col)
    {
        // current position is a wall.
        if ("X".equals(grid[row][col]))
        {
            return false;
        }

        // check for same column attack
        for (int i = row; i >= 0; i--)
        {
            if ("X".equals(grid[i][col]))
            {
                break;
            }
            if ("+".equals(grid[i][col]))
            {
                return false;
            }
        }
        // check for same row attack
        for (int i = col; i >= 0; i--)
        {
            if ("X".equals(grid[row][i]))
            {
                break;
            }
            if ("+".equals(grid[row][i]))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String argv[]) 
    {
        String[][] city = null;
        // City size
        int citySize = 8;

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt())
        {
            citySize = scan.nextInt();
            // eat '\n'
            // String a = scan.next();

            // end of file, termination
            if (0 >= citySize || citySize > 4)
            {
                return;
            }

            // build a new city
            city = new String[citySize][citySize];

            for (int i = 0; i < citySize; i++)
            {
                String line = scan.next();
                char[] arr = line.toCharArray();
                for (int j = 0; j < citySize; j++)
                {
                    if (arr[j] == 'X')
                    {
                        city[i][j] = "X";
                    }
                }
            }

            Main eq = new Main();

            eq.putBlockHouse(city, 0, 0);

            System.out.println(eq.getMaxBlock());
        }
    }
}