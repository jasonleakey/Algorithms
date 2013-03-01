package edu.algorithm.interview;

import edu.algorithm.datastruct.Stack;

public class Q3_6 extends Stack
{
    public void sort()
    {
        if (isEmpty())
        {
            return;
        }

        Stack s1 = new Stack();
        Stack s2 = new Stack();

        s1.push(pop());
        while (!isEmpty())
        {
            if ((Integer) top() > (Integer) s1.top())
            {
                while (!s1.isEmpty() && (Integer) s1.top() < (Integer) top())
                {
                    s2.push(s1.pop());
                }
                s1.push(pop());
                while (!s2.isEmpty())
                {
                    s1.push(s2.pop());
                }
            }
            else
            {
                s1.push(pop());
            }
        }

        while (!s1.isEmpty())
        {
            push(s1.pop());
        }
    }

    public void sort2()
    {
        if (isEmpty())
        {
            return;
        }

        // only use one stack. 
        Stack s1 = new Stack();

        s1.push(pop());
        while (!isEmpty())
        {
            Object item = pop();
            if ((Integer) item > (Integer) s1.top())
            {
                while (!s1.isEmpty() && (Integer) s1.top() < (Integer) item)
                {
                    push(s1.pop());
                }
            }
            s1.push(item);
        }

        while (!s1.isEmpty())
        {
            push(s1.pop());
        }
    }

    public static void main(String[] args)
    {
        Q3_6 s = new Q3_6();
        s.push(new Integer(5));
        s.push(new Integer(3));
        s.push(new Integer(9));
        s.push(new Integer(7));
        s.push(new Integer(2));
        s.push(new Integer(1));
        s.push(new Integer(5));
        s.push(new Integer(6));
        s.push(new Integer(8));
        s.push(new Integer(2));

        System.out.println(s);
        s.sort2();
        System.out.println(s);
    }
}
