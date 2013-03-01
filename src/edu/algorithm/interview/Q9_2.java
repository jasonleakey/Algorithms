package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

public class Q9_2
{
    public static int dfs(int[][] maze)
    {
        if (null == maze)
        {
            return 0;
        }
        return dfs(maze, 0, 0, 0);
    }
    
    private static List<String> path = new ArrayList<String>();

    private static int dfs(int[][] maze, int row, int col, int count)
    {
        if (row == maze.length - 1 && col == maze[0].length - 1)
        {
            for (String s : path)
            {
                System.out.print(s);
            }
            System.out.println();
            return count + 1;
        }
        
        if (row + 1 < maze.length && maze[row + 1][col] == 0)
        {
            path.add("↓");
            count = dfs(maze, row + 1, col, count);
            path.remove(path.size() - 1);
        }
        if (col + 1 < maze[0].length && maze[row][col + 1] == 0)
        {
            path.add("→");
            count = dfs(maze, row, col + 1, count);
            path.remove(path.size() - 1);
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        int[][] maze = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 },
                { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 } };
        System.out.println(dfs(maze));
    }
}
