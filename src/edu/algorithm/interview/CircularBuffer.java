package edu.algorithm.interview;

import java.util.Scanner;

public class CircularBuffer
{
    public static class Queue
    {
        private String[] Q;
        private int head;
        private int tail;
        
        public Queue(int size)
        {
            this.Q = new String[size];
            this.head = 0;
            this.tail = -1;
        }
        
        public void append(String s)
        {
            if (isEmpty())
            {
                Q[head] = s;
                tail = head;
                return;
            }
            
            if (next(tail) == head)
            {
                head = next(head);
            }
            
            tail = next(tail);
            Q[tail] = s;
        }
        public String remove()
        {
            if (isEmpty())
            {
                return null;
            }
            
            if (head == tail)
            {
                tail = -1;
            }
            
            String s = Q[head];
            head = next(head);
            return s;
        }
        
        public void list()
        {
            if (isEmpty())
            {
                return;
            }
            
            for (int p = head; p != tail; p = next(p))
            {
                System.out.println(Q[p]);
            }
            
            System.out.println(Q[tail]);
        }
        
        public int next(int d)
        {
            return (d + 1) % Q.length;
        }
        
        public boolean isEmpty()
        {
            return -1 == tail;
        }
    }
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        if (0 == N)
        {
            scan.close();
            return;
        }
        
        Queue q = new Queue(N);
        while (true)
        {
            String line = scan.nextLine();
            String[] command = line.split(" ");
            switch (command[0])
            {
                case "A":
                    int n = Integer.parseInt(command[1]);
                    for (int i = 0; i < n; i++)
                    {
                        line = scan.nextLine();
                        q.append(line);
                    }
                    break;
                case "R":
                    n = Integer.parseInt(command[1]);
                    for (int i = 0; i < n; i++)
                    {
                        q.remove();
                    }
                    break;
                case "L":
                    q.list();
                    break;
                case "Q":
                    scan.close();
                    return;
            }
        }
    }
}
