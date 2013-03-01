package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

import edu.algorithm.datastruct.Stack;

class StackC extends Stack
{
    private int size = 0;

    public StackC()
    {
        super();
    }

    @Override
    public void push(Object obj)
    {
        super.push(obj);
        size++;
    }

    @Override
    public Object pop()
    {
        Object p = super.pop();
        if (null != p)
        {
            size--;
        }
        return p;
    }

    public int count()
    {
        return size;
    }
}

// SetofStack
public class Q3_3
{
    private int threshold = 5;

    private List<StackC> stackList;

    public Q3_3()
    {
        StackC s = new StackC();
        stackList = new ArrayList<StackC>();
        stackList.add(s);
    }

    public void push(Object obj)
    {
        StackC s = stackList.get(stackList.size() - 1);
        s.push(obj);
        if (s.count() == threshold)
        {
            StackC s2 = new StackC();
            stackList.add(s2);
        }
    }

    public Object pop()
    {
        // empty
        if (0 == stackList.get(0).count())
        {
            return null;
        }

        StackC s = stackList.get(stackList.size() - 1);
        if (s.isEmpty())
        {
            stackList.remove(stackList.size() - 1);
            StackC s2 = stackList.get(stackList.size() - 1);
            return s2.pop();
        }

        return s.pop();
    }

    public Object popAt(int index)
    {
        StackC s = stackList.get(index);
        Object b = s.pop();
        if (s.isEmpty())
        {
            stackList.remove(index);
        }

        return b;
    }

    public int getThreshold()
    {
        return threshold;
    }

    public void setThreshold(int threshold)
    {
        this.threshold = threshold;
    }

    public static void main(String[] args)
    {
        Q3_3 ss = new Q3_3();
        
        ss.push(new Integer(1));
        ss.push(new Integer(2));
        ss.push(new Integer(3));
        ss.push(new Integer(4));
        ss.push(new Integer(5));
        ss.push(new Integer(6));
        ss.push(new Integer(7));
        ss.push(new Integer(8));
        ss.push(new Integer(9));
        ss.push(new Integer(10));
        ss.push(new Integer(11));
        ss.push(new Integer(12));
        ss.push(new Integer(13));
        ss.push(new Integer(14));
        ss.push(new Integer(15));
        ss.push(new Integer(16));
        System.out.println(ss.pop());
        System.out.println(ss.popAt(0));
        System.out.println(ss.popAt(2));
        System.out.println(ss.popAt(3));
        ss.push(new Integer(17));
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        System.out.println(ss.pop());
    }
}
