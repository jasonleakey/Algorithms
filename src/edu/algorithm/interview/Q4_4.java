package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.algorithm.datastruct.BinTree;
import edu.algorithm.datastruct.BinTree.TreeNode;

public class Q4_4
{
    public static List<LinkedList<TreeNode<Object>>> link(BinTree<Object> tree)
    {
        List<LinkedList<TreeNode<Object>>> L = new ArrayList<>();
        depLink(L, tree.root, 0);
        return L;
    }

    private static void depLink(List<LinkedList<TreeNode<Object>>> L,
            TreeNode<Object> node, int depth)
    {
        if (null == node)
        {
            return;
        }
        if (L.size() <= depth)
        {
            L.add(new LinkedList<TreeNode<Object>>());
        }
        LinkedList<TreeNode<Object>> p = L.get(depth);
        p.add(node);
        depLink(L, node.getLChild(), depth + 1);
        depLink(L, node.getRChild(), depth + 1);
    }

    public static List<LinkedList<TreeNode<Object>>> bfsLink2(
            BinTree<Object> tree)
    {
        if (null == tree.root)
        {
            return null;
        }

        List<LinkedList<TreeNode<Object>>> L = new ArrayList<>();
        Queue<TreeNode<Object>> q = new LinkedList<>();
        q.add(tree.root);

        while (q.size() > 0)
        {
            LinkedList<TreeNode<Object>> t = new LinkedList<>();
            while (q.size() > 0)
            {
                t.add(q.poll());
            }
            L.add(t);
            for (TreeNode<Object> node : t)
            {
                if (null != node.getLChild())
                {
                    q.add(node.getLChild());
                }
                if (null != node.getRChild())
                {
                    q.add(node.getRChild());
                }
            }
        }

        return L;
    }
    
    public static List<LinkedList<TreeNode<Object>>> bfsLink(
            BinTree<Object> tree)
    {
        if (null == tree.root)
        {
            return null;
        }

        List<LinkedList<TreeNode<Object>>> L = new ArrayList<>();
        // ACT AS THE QUEUE
        LinkedList<TreeNode<Object>> t = new LinkedList<>();
        t.add(tree.root);

        while (t.size() > 0)
        {
            L.add(t);
            LinkedList<TreeNode<Object>> parent = t;
            t = new LinkedList<>();
            for (TreeNode<Object> node : parent)
            {
                if (null != node.getLChild())
                {
                    t.add(node.getLChild());
                }
                if (null != node.getRChild())
                {
                    t.add(node.getRChild());
                }
            }
        }

        return L;
    }

    public static void main(String[] args)
    {
        Integer[] s = new Integer[] { 5, 3, 9, null, 4, 8, null, null, null, 3,
                7, null, 1 };
        BinTree<Object> tree = new BinTree<Object>(s);
        System.out.println(tree);

        System.out.println("Linked List:");
        List<LinkedList<TreeNode<Object>>> p = bfsLink(tree);
        for (LinkedList<TreeNode<Object>> q : p)
        {
            for (TreeNode<Object> node : q)
            {
                System.out.print(node.getValue() + "  ");
            }
            System.out.println();
        }
    }
}
