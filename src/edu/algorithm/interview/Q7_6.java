package edu.algorithm.interview;

import java.util.HashMap;

public class Q7_6
{
    private static class Point
    {
        public double x;

        public double y;

        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
    }

    private static class Line
    {
        double RANGE = 1e-4;

        double slope;

        double intercept;

        public Line(Point p1, Point p2)
        {
            if (Math.abs(p1.x - p2.x) < RANGE)
            {
                // If the line is vertical
                // then denote it in a way slope = MAX_VALUE and intercept is x
                slope = Integer.MAX_VALUE;
                intercept = p1.x;
            }
            else
            {
                slope = (p1.y - p2.y) / (p1.x - p2.x);
                intercept = -slope * p1.x + p1.y;
            }
        }

        @Override
        public int hashCode()
        {
            int sl = (int) (slope * 1000);
            int in = (int) (intercept * 1000);
            return sl | in;
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
            if (!(obj instanceof Line))
            {
                return false;
            }
            Line other = (Line) obj;
            if (Math.abs(intercept - other.intercept) > RANGE)
            {
                return false;
            }
            if (Math.abs(slope - other.slope) > RANGE)
            {
                return false;
            }
            return true;
        }

        @Override
        public String toString()
        {
            return "slope: " + Double.toString(slope) + ", intercept: "
                    + Double.toString(intercept);
        }
    }

    public static Line findBestLine(Point[] pts)
    {
        Line bestLine = null;
        HashMap<Line, Integer> map = new HashMap<Line, Integer>();
        for (int i = 0; i < pts.length - 1; i++)
        {
            for (int j = i + 1; j < pts.length; j++)
            {
                Line l = new Line(pts[i], pts[j]);
                if (map.containsKey(l))
                {
                    map.put(l, map.get(l) + 1);
                }
                else
                {
                    map.put(l, 1);
                }

                if (null == bestLine || map.get(l) > map.get(bestLine))
                {
                    bestLine = l;
                }
            }
        }
        return bestLine;
    }

    public static void main(String[] args)
    {
        Point[] pts = new Point[5];
        pts[0] = new Point(-0.3, 0.8);
        pts[1] = new Point(0.5, 0.2);
        pts[2] = new Point(1.0, 0.4);
        pts[3] = new Point(2.0, 0.8);
        pts[4] = new Point(4.0, 1.6);
        System.out.println(findBestLine(pts));
    }
}
