package edu.algorithm.interview;

import java.util.Scanner;

import edu.algorithm.datastruct.Stack;

class BinSearchTree
{
    public static class Node
    {
        private int data;

        private Node left;

        private Node right;

        public Node left()
        {
            return left;
        }

        public void setLeft(Node left)
        {
            this.left = left;
        }

        public Node right()
        {
            return right;
        }

        public void setRight(Node right)
        {
            this.right = right;
        }

        public Node(int x)
        {
            this.data = x;
        }

        public int value()
        {
            return data;
        }

        public void setValue(int data)
        {
            this.data = data;
        }
    }

    private Node root = null;

    public Node root()
    {
        return root;
    }

    public int rank(int x)
    {
        int count = 0;
        Node p = root;
        Stack s = new Stack();
        boolean isFound = false;
        while (null != p || !s.isEmpty())
        {
            while (null != p)
            {
                s.push(p);
                p = p.left();
            }
            p = (Node) s.pop();
            if (p.value() <= x)
            {
                if (p.value() == x)
                {
                    isFound = true;
                }
                count++;
            }
            else
            {
                break;
            }
            p = p.right();
        }
        return isFound ?  count - 1 : -1;
    }

    public void insert(int x)
    {
        if (null == root)
        {
            root = new Node(x);
            return;
        }

        Node p = root;
        Node q = p;
        // flag 0 : Go left;
        // flag 1 : Go right;
        int flag = 0;
        while (null != p)
        {
            if (x <= p.value())
            {
                q = p;
                p = p.left;
                flag = 0;
            }
            else
            {
                q = p;
                p = p.right();
                flag = 1;
            }
        }
        p = new Node(x);
        if (flag == 0)
        {
            q.setLeft(p);
        }
        else
        {
            q.setRight(p);
        }
    }
}

public class Q11_8
{
    private BinSearchTree tree;

    public Q11_8()
    {
        tree = new BinSearchTree();
    }

    public void track(int x)
    {
        tree.insert(x);
    }

    public int getRankOfNumber(int x)
    {
        return tree.rank(x);
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Q11_8 q = new Q11_8();
        while (scan.hasNextInt())
        {
            int x = scan.nextInt();
            q.track(x);
            System.out.print(q.getRankOfNumber(1) + ", ");
            System.out.print(q.getRankOfNumber(4) + ", ");
            System.out.print(q.getRankOfNumber(9));
        }

        scan.close();
    }
}
