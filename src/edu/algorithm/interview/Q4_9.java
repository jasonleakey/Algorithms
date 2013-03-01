package edu.algorithm.interview;

import edu.algorithm.datastruct.BinTree;
import edu.algorithm.datastruct.BinTree.TreeNode;

public class Q4_9
{
    // T: O(n log(n))
    private static void findSum(TreeNode<Integer> node, int sum, int[] path, int level)
    {
        if (null == node)
        {
            return;
        }
        
        path[level] = node.getValue();
        int t = 0;
        for (int i = level; i >= 0; i--)
        {
            t += path[i];
            if (t == sum)
            {
                print(path, i, level);
            }
        }
        
        findSum(node.getLChild(), sum, path, level + 1);
        findSum(node.getRChild(), sum, path, level + 1);
    }
    
    public static void findSum(BinTree<Integer> tree, int sum)
    {
        TreeNode<Integer> node = tree.root;
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }
    
    private static int depth(TreeNode<Integer> node)
    {
        if (null == node)
        {
            return 0;
        }
        else
        {
            return 1 + Math.max(depth(node.getLChild()), depth(node.getRChild()));
        }
    }
    
    
    private static void print(int[] path, int start, int end)
    {
        for (int i = start; i <= end; i++)
        {
            System.out.print(path[i] + "->");
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        BinTree<Integer> largeTree = new BinTree<Integer>(new Integer[] { 3, 1,
                9, 2, 4, 5, 8, null, null, 7, 9, null, 5, null, null, null,
                null, null, null, null, null, 6, 0 });
        System.out.println(largeTree);
        findSum(largeTree, 13);
    }
}
