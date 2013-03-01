package edu.algorithm.interview;

public class Q5_2
{
    public static String parseReal(double t)
    {
        if (t <= 0 || t >= 1)
        {
            return "ERROR";
        }
        
        StringBuilder buf = new StringBuilder();
        buf.append('.');
        double dividor = 0.5;
        while (t > 0 && buf.length() <= 32)
        {
            if (t >= dividor)
            {
                buf.append('1');
                t -= dividor;
            }
            else
            {
                buf.append('0');
            }
            dividor /= 2;
        }
        
        if (0 == t)
        {
            return buf.toString();
        }
        else
        {
            return "ERROR";
        }
    }
    
    public static void main(String[] args)
    {
//        double t = 0.72;
        double t = 0.5625;
        System.out.println(parseReal(t));
    }
}
