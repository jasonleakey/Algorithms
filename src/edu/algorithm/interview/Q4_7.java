package edu.algorithm.interview;

import edu.algorithm.datastruct.BinTree;
import edu.algorithm.datastruct.BinTree.TreeNode;

public class Q4_7
{
    public static TreeNode<Integer> commonAncestor(BinTree<Integer> tree,
            TreeNode<Integer> p, TreeNode<Integer> q)
    {
        if (!cover(tree.root, p) || !cover(tree.root, q))
        {
            return null;
        }

        return commonAncestor(tree.root, p, q);
    }

    public static boolean isFound = false;

    public static TreeNode<Integer> commonAncestor2(BinTree<Integer> tree,
            TreeNode<Integer> p, TreeNode<Integer> q)
    {
        return commonAncestor2(tree.root, p, q);
    }

    private static TreeNode<Integer> commonAncestor2(TreeNode<Integer> root,
            TreeNode<Integer> p, TreeNode<Integer> q)
    {
        if (null == root)
        {
            return null;
        }
        TreeNode<Integer> leftResult = commonAncestor2(root.getLChild(), p, q);
        if (isFound)
        {
            return leftResult;
        }
        TreeNode<Integer> rightResult = commonAncestor2(root.getRChild(), p, q);
        if (isFound)
        {
            return rightResult;
        }
        if (root == p || root == q)
        {
            if (leftResult != null || rightResult != null)
            {
                isFound = true;
            }
            return root;
        }
        else
        {
            if (leftResult != null && rightResult != null)
            {
                isFound = true;
                return root;
            }
            else if (leftResult != null)
            {
                return leftResult;
            }
            else if (rightResult != null)
            {
                return rightResult;
            }
            else
            {
                return null;
            }
        }
    }

    private static boolean cover(TreeNode<Integer> root, TreeNode<Integer> p)
    {
        if (null == root)
        {
            return false;
        }
        if (root == p)
        {
            return true;
        }
        return cover(root.getLChild(), p) || cover(root.getRChild(), p);
    }

    private static TreeNode<Integer> commonAncestor(TreeNode<Integer> root,
            TreeNode<Integer> p, TreeNode<Integer> q)
    {
        if (null == root)
        {
            return null;
        }
        if (root == p || root == q)
        {
            return root;
        }

        boolean isPonLeft = cover(root.getLChild(), p);
        boolean isQonLeft = cover(root.getLChild(), q);

        if (isPonLeft != isQonLeft)
        {
            return root;
        }

        return isPonLeft && isQonLeft ? commonAncestor(root.getLChild(), p, q)
                : commonAncestor(root.getRChild(), p, q);
    }

    public static void main(String[] args)
    {
        BinTree<Integer> tree = new BinTree<Integer>(new Integer[] { 9, 2, 7,
                4, 5, 8, 3, null, 30, 12, 17, null, null, 6, 16, null, null,
                13, null, null, null, null, null, null, null, null, null, null,
                29 });
        System.out.println(tree);
        TreeNode<Integer> root = tree.root;
        System.out.println(commonAncestor2(root, root.getLChild().getRChild()
                .getRChild(), root.getLChild().getRChild().getLChild()));
    }
}
