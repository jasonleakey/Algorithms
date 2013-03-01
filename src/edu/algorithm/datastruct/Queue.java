package edu.algorithm.datastruct;

import edu.algorithm.datastruct.LinkList.Node;


public class Queue
{
    private Node first;
    private Node last;
    
    public Queue()
    {
        this.first = null;
        this.last = null;
    }
    
    public void enqueue(Object obj)
    {
        Node p = new Node(obj);
        if (isEmpty())
        {
            first = p;
            last = p;
        }
        else
        {
            last.next = p;
            last = p;
        }
    }
    
    public Object dequeue()
    {
        if (isEmpty())
        {
            return null;
        }
        
        Object obj = first.data;
        first = first.next;
        return obj;
    }
    
    public boolean isEmpty()
    {
        return null == first;
    }
}
