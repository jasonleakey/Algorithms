package edu.algorithm.interview;

import edu.algorithm.datastruct.BinSearchTree;
import edu.algorithm.datastruct.BinTree.TreeNode;

public class Q4_6
{
    public static TreeNode<Integer> next(TreeNode<Integer> node)
    {
        if (null == node)
        {
            return null;
        }

        if (null != node.getRChild())
        {
            TreeNode<Integer> p = node.getRChild();
            while (null != p.getLChild())
            {
                p = p.getLChild();
            }
            return p;
        }
        else
        {
            TreeNode<Integer> p = node;
            TreeNode<Integer> q = node.getParent();
            while (null != q && q.getLChild() != p)
            {
                p = q;
                q = q.getParent();
            }
            return q;
        }
    }

    public static void main(String[] args)
    {
        Integer[] s = new Integer[] { 11, 4, 22, 1, 8, 17, 29, null, 2, 5, 9,
                14, 19, 25, 33 };
        BinSearchTree<Integer> t = new BinSearchTree<Integer>(s);
        System.out.println(t);
        System.out.println("isBinarySearchTree: " + next(t.root.getLChild().getRChild().getRChild()));
        System.out.println("isBinarySearchTree: " + next(t.root.getLChild().getRChild().getRChild()));
        System.out.println("isBinarySearchTree: " + next(t.root.getRChild().getRChild().getRChild()));
    }
}
