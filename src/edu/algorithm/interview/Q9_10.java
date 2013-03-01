package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.HashMap;

public class Q9_10
{
    private static class Box implements Cloneable
    {
        public int w;

        public int h;

        public int d;

        public Box(int w, int h, int d)
        {
            this.w = w;
            this.h = h;
            this.d = d;
        }

        public boolean isSmaller(Box other)
        {
            return (w < other.w && h < other.h && d < other.d);
        }

        @Override
        public String toString()
        {
            return "(" + w + "," + h + "," + d + ")";
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + d;
            result = prime * result + h;
            result = prime * result + w;
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
            if (!(obj instanceof Box))
            {
                return false;
            }
            Box other = (Box) obj;
            if (d != other.d)
            {
                return false;
            }
            if (h != other.h)
            {
                return false;
            }
            if (w != other.w)
            {
                return false;
            }
            return true;
        }
        
        @Override
        protected Box clone() 
        {
            return new Box(w, h, d);
        }
    }

    public static ArrayList<Box> stackBox(Box[] B)
    {
        HashMap<Box, ArrayList<Box>> cache = new HashMap<Box, ArrayList<Box>>();
        return stackBox(B, null, cache);
    }

    private static ArrayList<Box> stackBox(Box[] B, Box bottom,
            HashMap<Box, ArrayList<Box>> cache)
    {
        if (null != bottom && cache.containsKey(bottom))
        {
            ArrayList<Box> maxStackCopy = new ArrayList<Box>();
            for (Box b : cache.get(bottom))
            {
                maxStackCopy.add(b.clone());
            } 
            return maxStackCopy;
        }

        int maxHeight = 0;
        ArrayList<Box> maxStack = new ArrayList<Box>();
        for (int i = 0; i < B.length; i++)
        {
            if (null == bottom || B[i].isSmaller(bottom))
            {
                ArrayList<Box> stack = stackBox(B, B[i], cache);
                int sum = 0;
                for (Box b : stack)
                {
                    sum += b.h;
                }
                if (sum > maxHeight)
                {
                    maxHeight = sum;
                    maxStack = stack;
                }
            }
        }
        if (null != bottom)
        {
            maxStack.add(0, bottom);
        }

        if (!cache.containsKey(bottom))
        {
            ArrayList<Box> maxStackCopy = new ArrayList<Box>();
            for (Box b : maxStack)
            {
                maxStackCopy.add(b.clone());
            } 
            cache.put(bottom, maxStackCopy);
        }
        return maxStack;
    }

    public static void main(String[] args)
    {
        Box[] B = new Box[10];
        B[0] = new Box(3, 3, 3);
        B[1] = new Box(2, 8, 5);
        B[2] = new Box(6, 7, 9);
        B[3] = new Box(2, 3, 1);
        B[4] = new Box(5, 5, 5);
        B[5] = new Box(10, 12, 6);
        B[6] = new Box(8, 8, 4);
        B[7] = new Box(4, 6, 4);
        B[8] = new Box(11, 8, 7);
        B[9] = new Box(1, 2, 1);
        System.out.println(stackBox(B));
    }
}
