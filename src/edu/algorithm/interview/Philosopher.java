package edu.algorithm.interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Chopstick
{
    private Lock lock;

    public Chopstick()
    {
        this.lock = new ReentrantLock();
    }

    public boolean pickUp()
    {
        return lock.tryLock();
    }

    public void putDown()
    {
        lock.unlock();
    }
}

public class Philosopher extends Thread
{
    private int id = 0;

    private int bites = 10;

    private Chopstick left;

    private Chopstick right;

    public Philosopher(int id, Chopstick left, Chopstick right)
    {
        this.left = left;
        this.right = right;
        this.id = id;
    }

    public void eat()
    {
        if (pickUp())
        {
            chew();
            putDown();
        }
    }

    public boolean pickUp()
    {
        if (!left.pickUp())
        {
            return false;
        }
        if (!right.pickUp())
        {
            left.putDown();
            return false;
        }
        return true;
    }

    public void putDown()
    {
        left.putDown();
        right.putDown();
    }

    public void chew()
    {
        System.out.println("Phil #" + id + " eating...");
    }

    @Override
    public void run()
    {
        for (int i = 0; i < bites; i++)
        {
            eat();
        }
    }

    public static void main(String[] args)
    {
        int N = 5;
        Chopstick[] chops = new Chopstick[N];
        for (int i = 0; i < N; i++)
        {
            chops[i] = new Chopstick();
        }
        Philosopher[] phis = new Philosopher[N];
        for (int i = 0; i < N; i++)
        {
            phis[i] = new Philosopher(i, chops[i % N], chops[(i + 1) % N]);
        }

        for (int i = N - 1; i >= 0; i--)
        {
            phis[i].start();
        }
    }
}
