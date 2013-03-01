package edu.algorithm.interview;

import edu.algorithm.datastruct.Stack;

public class Q3_5
{
    private Stack s1;
    private Stack s2;
    
    public Q3_5()
    {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void enqueue(Object obj)
    {
        s1.push(obj);
    }
    
    public Object dequeue()
    {
        if (s2.isEmpty())
        {
            while (!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
        }
        
        return s2.pop();
    }
    
    public static void main(String[] args)
    {
        Q3_5 q = new Q3_5();
        q.enqueue(new Integer(1));
        q.enqueue(new Integer(2));
        q.enqueue(new Integer(3));
        System.out.println(q.dequeue());
        q.enqueue(new Integer(4));
        q.enqueue(new Integer(5));
        q.enqueue(new Integer(6));
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(new Integer(7));
        System.out.println(q.dequeue());
        q.enqueue(new Integer(8));
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
