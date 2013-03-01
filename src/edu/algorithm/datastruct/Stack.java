package edu.algorithm.datastruct;

import edu.algorithm.datastruct.LinkList.Node;


public class Stack
{
    private Node top;

    public Stack()
    {
        this.top = null;
    }

    public Object pop()
    {
        if (isEmpty())
        {
            return null;
        }
        
        Object obj = top.data;
        top = top.next;
        return obj;
    }

    public void push(Object obj)
    {
        Node p = new Node(obj);
        p.next = top;
        top = p;
    }

    public Object top()
    {
        return isEmpty() ? null : top.data;
    }

    public boolean isEmpty()
    {
        return null == top;
    }
    
    @Override
    public String toString()
    {
        if (isEmpty())
        {
            return null;
        }
        
        StringBuilder buf = new StringBuilder();
        Node p = top;
        while (null != p.next)
        {
            buf.append(String.valueOf(p.data) + " -> ");
            p = p.next;
        }
        buf.append(String.valueOf(p.data));
        
        return buf.toString();
    }
}
