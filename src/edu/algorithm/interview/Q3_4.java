package edu.algorithm.interview;

import edu.algorithm.datastruct.Stack;

public class Q3_4
{
    public static void hanoi(int n, char x, char y, char z)
    {
        // successfully done.
        if (n > 0)
        {
            hanoi(n - 1, x, z, y);
            System.out.println("Move Disk " + String.valueOf(n) + " from " + x
                    + " to " + z);
            hanoi(n - 1, y, x, z);
        }
    }

    private static class Tower extends Stack
    {
        public char name;

        public Tower(char name)
        {
            this.name = name;
        }

        @Override
        public void push(Object obj)
        {
            super.push((Integer) obj);
        }

        @Override
        public Integer pop()
        {
            return (Integer) super.pop();
        }

        @Override
        public Integer top()
        {
            return (Integer) super.top();
        }
    }

    public static void hanoi2(int n)
    {
        int MAX_STEP = (int) Math.pow(2, n) - 1;

        Tower[] tows = new Tower[3];
        if (0 == n % 2)
        {
            // even number of disks, tower sequence in clockwise should be
            // A -> B -> C
            tows[0] = new Tower('A');
            tows[1] = new Tower('B');
            tows[2] = new Tower('C');
        }
        else
        {
            // odd number of disks, tower sequence should be A -> C -> B
            tows[0] = new Tower('A');
            tows[1] = new Tower('C');
            tows[2] = new Tower('B');
        }
        // insert disks.
        for (int i = n; i > 0; i--)
        {
            tows[0].push(new Integer(i));
        }
        
        int counter = 0;

        int index = 0;
        Integer disk;
        while (counter < MAX_STEP)
        {
            disk = tows[index % 3].pop();
            tows[(index + 1) % 3].push(disk);
            System.out.println(++counter + ": " + "Move disk " + disk + " from "
                    + tows[index % 3].name + " to " + tows[(index + 1) % 3].name);
            index++;

            if (counter < MAX_STEP)
            {
                if (tows[(index + 1) % 3].top() == null || tows[(index - 1) % 3].top() != null
                        && tows[(index + 1) % 3].top() > tows[(index - 1) % 3].top())
                {
                    disk = tows[(index - 1) % 3].pop();
                    tows[(index + 1) % 3].push(disk);
                    System.out.println(+ ++counter + ": " + "Move disk " + disk
                            + " from " + tows[(index - 1) % 3].name + " to "
                            + tows[(index + 1) % 3].name);
                }
                else
                {
                    disk = tows[(index + 1) % 3].pop();
                    tows[(index - 1) % 3].push(disk);
                    System.out.println(+ ++counter + ": " + "Move disk " + disk
                            + " from " + tows[(index + 1) % 3].name + " to "
                            + tows[(index - 1) % 3].name);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int N = 3;
        char x = 'x';
        char y = 'y';
        char z = 'z';

        // hanoi(N, x, y, z);
        hanoi2(N);
    }
}
