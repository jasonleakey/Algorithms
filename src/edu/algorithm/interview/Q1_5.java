package edu.algorithm.interview;

public class Q1_5
{
    public static String compress(String orig)
    {
        assert(orig.length() > 0);
        StringBuilder buf = new StringBuilder();
        // ADD the first elem to the buffer.
        buf.append(orig.charAt(0));
        
        int counter = 1;
        // FROM the secondary elem
        for (int i = 1; i < orig.length(); i++)
        {
            // the current char differs from its previous char
            if (orig.charAt(i) != orig.charAt(i - 1))
            {
                // then output the previous counter
                buf.append(counter);
                // clear counter
                counter = 1;
                // add the current elem to the buffer. 
                buf.append(orig.charAt(i));
            }
            else
            {
                counter++;
            }
        }
        buf.append(counter);
        
        if (buf.length() < orig.length())
        {
            return buf.toString();
        }
        else
        {
            return orig;
        }
    }
    
    public static void main(String[] args)
    {
        String str = "aabbbbbbcaaa";
        
        System.out.println(compress(str));
    }
}
