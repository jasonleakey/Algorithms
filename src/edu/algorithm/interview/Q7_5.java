package edu.algorithm.interview;

public class Q7_5
{
    private static class Square
    {
        public double xmin;
        public double ymin;
        public double sizeLen;
        
        public Square(double xmin, double ymin, double len)
        {
            this.xmin = xmin;
            this.ymin = ymin;
            this.sizeLen = len;
        }
        
        public double[] cutHalf(Square s)
        {
            double RANGE = 1e-5;
            double[] line = new double[2];
            double x1 = xmin + 0.5 * sizeLen;
            double y1 = ymin + 0.5 * sizeLen;
            double x2 = s.xmin + 0.5 * s.sizeLen;
            double y2 = s.ymin + 0.5 * s.sizeLen;
            line[0] = (y2 - y1) / (x2 - x1);
            line[1] = line[0] * (-x1) + y1;
            return line;
        }
    }
    
    public static void main(String[] args)
    {
        Square s1 = new Square(-3, 1, 2);
        Square s2 = new Square(1, -3, 2);
        double[] line = s1.cutHalf(s2);
        System.out.println(line[0] + ", " + line[1]);
    }
}
