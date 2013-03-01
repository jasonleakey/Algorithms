package edu.algorithm.interview;

import edu.algorithm.datastruct.Stack;

public class Q3_2 
{
    Stack s1;
    Stack s2;
    
    public Q3_2()
    {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(Object obj)
    {
        if (s1.isEmpty() || (Integer) obj < (Integer) s1.top())
        {
            s1.push(obj);
        }
        
        s2.push(obj);
    }
    
    public Object pop()
    {
        if (!s1.isEmpty() && s1.top().equals(s2.top()))
        {
            s1.pop();
        }
        return s2.pop();
    }
    
    public Object min()
    {
        return s1.isEmpty() ? null : s1.top();
    }
    
    public static void main(String[] args)
    {
        Q3_2 q = new Q3_2();
        q.push(new Integer(5));
        System.out.println(q.min());
        q.push(new Integer(6));
        System.out.println(q.min());
        q.push(new Integer(3));
        System.out.println(q.min());
        q.push(new Integer(7));
        System.out.println(q.min());
        
        q.pop();
        System.out.println(q.min());
        q.pop();
        System.out.println(q.min());
    }
}
