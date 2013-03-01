package edu.algorithm.interview;

import edu.algorithm.datastruct.BinTree;
import edu.algorithm.datastruct.BinTree.TreeNode;

public class Q4_8
{
    // T: O(n + km), in which n is the scale of large tree with millions of nodes,
    // k is the number of occurrences of the small tree in the large tree, m is the scale of 
    // small tree with hundreds of nodes. 
    // S: O(log(n) + log(m))
    public static boolean isSubtree(BinTree<Integer> mTree,
            BinTree<Integer> hTree)
    {
        if (null == hTree || null == hTree.root)
        {
            return true;
        }
        return isSubtree(mTree.root, hTree.root);
    }

    private static boolean isSubtree(TreeNode<Integer> largeRoot,
            TreeNode<Integer> smallRoot)
    {
        if (largeRoot != null)
        {
            if (largeRoot.getValue().equals(smallRoot.getValue()))
            {
                if (isSame(largeRoot, smallRoot))
                {
                    return true;
                }
            }
            else
            {
                return isSubtree(largeRoot.getLChild(), smallRoot)
                        || isSubtree(largeRoot.getRChild(), smallRoot);
            }
        }
        return false;
    }

    private static boolean isSame(TreeNode<Integer> largeRoot,
            TreeNode<Integer> smallRoot)
    {
        if (null == largeRoot && null == smallRoot)
        {
            return true;
        }
        else if ((largeRoot != null && null == smallRoot)
                || (null == largeRoot && null != smallRoot))
        {
            return false;
        }
        else if (!largeRoot.getValue().equals(smallRoot.getValue()))
        {
            return false;
        }
        else
        {
            return isSame(largeRoot.getLChild(), smallRoot.getLChild())
                    && isSame(largeRoot.getRChild(), smallRoot.getRChild());
        }
    }

    public static void main(String[] args)
    {
        BinTree<Integer> largeTree = new BinTree<Integer>(new Integer[] { 3, 1,
                9, 2, 4, 5, 8, null, null, 7, 9, null, 5, null, null, null,
                null, null, null, null, null, 6, 0 });
        BinTree<Integer> smallTree = new BinTree<Integer>(new Integer[] { 4, 7,
                9, null, null, 6, 0 });
        System.out.println("Large Tree:");
        System.out.println(largeTree);
        System.out.println("Small Tree:");
        System.out.println(smallTree);
        System.out.println(isSubtree(largeTree, smallTree));
    }
}
