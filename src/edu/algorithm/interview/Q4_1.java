package edu.algorithm.interview;

import edu.algorithm.datastruct.BinTree;
import edu.algorithm.datastruct.BinTree.TreeNode;

public class Q4_1
{
    private static final int NON_BALANCE = -1;
    
    private static boolean BALANCED = true;

    public static int depth(TreeNode<Object> node)
    {
        if (null == node)
        {
            return 0;
        }

        int ldepth = depth(node.getLChild());
        int rdepth = depth(node.getRChild());
        // NOT balanced.
        // return -2;
        if (NON_BALANCE == ldepth || NON_BALANCE == rdepth || Math.abs(ldepth - rdepth) > 1)
        {
            return NON_BALANCE;
        }
        return Math.max(ldepth, rdepth) + 1;
    }

    public static boolean isBalanced(BinTree<Object> tree)
    {
        return (NON_BALANCE == depth(tree.root)) ? false : true;
    }
    
    public static boolean isBalanced2(BinTree<Object> tree)
    {
        BALANCED = true;
        depth2(tree.root);
        return BALANCED;
    }
    
    private static int depth2(TreeNode<Object> node)
    {
        if (null == node)
        {
            return 0;
        }
        
        int ldepth = depth2(node.getLChild());
        int rdepth = depth2(node.getRChild());
        
        if (!BALANCED || Math.abs(ldepth - rdepth) > 1)
        {
            BALANCED = false;
        }
        
        return Math.max(ldepth, rdepth) + 1;
    }

    public static void main(String[] args)
    {
        Integer[] s = new Integer[] { 5, 3, 9, null, 4, 8, null, null, null, 3,
                7, null, 1 };
        Integer[] s2 = new Integer[] { 5, 3, 9, 2, 4, 8, 6, null, null, 3,
                7, null, 1 };
        BinTree<Object> tree = new BinTree<Object>(s);
        BinTree<Object> tree2 = new BinTree<Object>(s2);
        System.out.println("s: " + isBalanced2(tree) + '\n' + tree);
        System.out.println("s2: " + isBalanced2(tree2) + '\n' + tree2);
    }
}
