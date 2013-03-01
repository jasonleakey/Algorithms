package edu.algorithm.interview;

import edu.algorithm.datastruct.BinTree;
import edu.algorithm.datastruct.BinTree.TreeNode;
import edu.algorithm.datastruct.Stack;

public class Q4_5
{
    private static Integer prevNum = Integer.MIN_VALUE;

    public static boolean isBST(BinTree<Integer> tree)
    {
        return checkBST(tree.root);
    }

    // Inorder traversal recursively
    private static boolean checkBST(TreeNode<Integer> node)
    {
        if (null == node)
        {
            return true;
        }

        if (!checkBST(node.getLChild()))
        {
            return false;
        }

        if (node.getValue() < prevNum)
        {
            return false;
        }
        prevNum = node.getValue();

        if (!checkBST(node.getRChild()))
        {
            return false;
        }

        return true;
    }

    // Inorder traversal iteratively 
    @SuppressWarnings("unchecked")
    public static boolean isBST2(BinTree<Integer> tree)
    {
        if (null == tree.root)
        {
            return true;
        }

        Stack s = new Stack();
        TreeNode<Integer> current = tree.root;
        Integer prevNum = Integer.MIN_VALUE;

        while (null != current || !s.isEmpty())
        {
            if (null != current)
            {
                s.push(current);
                current = current.getLChild();
            }
            else
            {
                current = (TreeNode<Integer>) s.pop();
                if (prevNum > current.getValue())
                {
                    return false;
                }
                prevNum = current.getValue();
                current = current.getRChild();
            }
        }

        return true;
    }
    
    // According to the definition of binary search tree. 
    public static boolean isBST3(BinTree<Integer> tree)
    {
        return checkBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean checkBST(TreeNode<Integer> node, int min, int max)
    {
        if (null == node)
        {
            return true;
        }
        
        if (node.getValue() > max || node.getValue() <= min)
        {
            return false;
        }
        
        if (!checkBST(node.getLChild(), min, node.getValue()) || !checkBST(node.getRChild(), node.getValue(), max))
        {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args)
    {
        // Integer[] s = new Integer[] { 5, 3, 9, null, 4, 8, null, null, null,
        // 3,
        // 7, null, 1 };
        // Integer[] s = new Integer[] { 11, 4, 22, 1, 8, 17, 29, null, 2, 5, 9,
        // 14, 19, 25, 33 };
        Integer[] s = new Integer[] { 11, 4, 22, 1, 8, 3, 29 };
        BinTree<Integer> t = new BinTree<Integer>(s);
        System.out.println(t);
        System.out.println("isBinarySearchTree: " + isBST2(t));
    }
}
