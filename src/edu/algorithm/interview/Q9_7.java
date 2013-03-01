package edu.algorithm.interview;

import java.util.HashSet;

public class Q9_7
{
    private static class Point
    {
        public int row;

        public int col;

        public Point(int row, int col)
        {
            this.row = row;
            this.col = col;
        }

        public Point left()
        {
            return new Point(row, col - 1);
        }

        public Point right()
        {
            return new Point(row, col + 1);
        }

        public Point up()
        {
            return new Point(row - 1, col);
        }

        public Point down()
        {
            return new Point(row + 1, col);
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + row;
            result = prime * result + col;
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null)
            {
                return false;
            }
            if (!(obj instanceof Point))
            {
                return false;
            }
            Point other = (Point) obj;
            if (row != other.row)
            {
                return false;
            }
            if (col != other.col)
            {
                return false;
            }
            return true;
        }

    }

    public static void paintFill(int[][] mat, Point p, int newColor)
    {
        if (null == mat || p.row < 0 || p.row >= mat.length || p.col < 0
                || p.col >= mat[0].length)
        {
            return;
        }

        int origColor = mat[p.row][p.col];
        HashSet<Point> area = new HashSet<Point>();
        scan(mat, p, origColor, area);
        for (Point q : area)
        {
            mat[q.row][q.col] = newColor;
        }
    }

    private static void scan(int[][] mat, Point p, int origColor,
            HashSet<Point> area)
    {
        if (p.row < 0 || p.row >= mat.length || p.col < 0 || p.col >= mat[0].length
                || mat[p.row][p.col] != origColor || area.contains(p))
        {
            return;
        }

        area.add(p);
        scan(mat, p.left(), origColor, area);
        scan(mat, p.right(), origColor, area);
        scan(mat, p.up(), origColor, area);
        scan(mat, p.down(), origColor, area);
    }

    public static void disp(int[][] mat)
    {
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[][] screen = new int[][] { { 3, 3, 3, 3, 3, 3 },
                { 3, 4, 3, 3, 4, 4 }, { 3, 4, 5, 5, 4, 4 },
                { 3, 4, 4, 4, 5, 4 }, { 3, 3, 4, 5, 5, 3 },
                { 3, 4, 3, 3, 4, 4 } };
        disp(screen);
        System.out.println();
        paintFill(screen, new Point(3, 1), 3);
        disp(screen);
        
        System.out.println();
        paintFill(screen, new Point(5, 0), 5);
        disp(screen);
    }
}
