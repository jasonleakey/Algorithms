package edu.algorithm.interview;

import java.util.Iterator;


public class Q14_6<T> implements Iterable<T>
{
    private T[] items;
    private int head = 0;
    
    public Q14_6(T[] items)
    {
        this.items = items;
    }
    
    public Q14_6(int size)
    {
        this.items = (T[]) new Object[size];
    }
    
    public int shift(int offset)
    {
        if (offset < 0)
        {
            offset += items.length;
        }
        return (head + offset) % items.length;
    }
    
    public void rotate(int offset)
    {
        head = shift(offset);
    }
    
    public T get(int i)
    {
        if (i < 0 || i >= items.length)
        {
            throw new IndexOutOfBoundsException("...");
        }
        return items[shift(i)];
    }
    
    public void set(int i, T item)
    {
        items[shift(i)] = item;
    }

    @Override
    public Iterator iterator()
    {
        return new CircularArrayIterator();
    }
    
    private class CircularArrayIterator implements Iterator
    {
        private int index = 0;

        @Override
        public boolean hasNext()
        {
            return index < items.length;
        }

        @Override
        public T next()
        {
            return items[shift(index++)];
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("...");
        }
    }
    
    public static void main(String[] args)
    {
        Q14_6<Integer> arr = new Q14_6<>(new Integer[]{10, 1, 2, 3, 8, 5, -2, 6});
        arr.rotate(-2);
        for (int a : arr)
        {
            System.out.print(String.valueOf(a) + "  ");
        }
        System.out.println();
    }
}
