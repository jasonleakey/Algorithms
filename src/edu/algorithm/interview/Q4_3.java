package edu.algorithm.interview;

import edu.algorithm.datastruct.BinSearchTree;

public class Q4_3<T extends Comparable<? super T>> extends BinSearchTree<T>
{
    public Q4_3(T[] seq)
    {
        root = createTree(seq, 0, seq.length - 1);
    }
    
    private TreeNode<T> createTree(T[] seq, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode<T> node = new TreeNode<T>(seq[mid]);
        TreeNode<T> lchild = createTree(seq, start, mid - 1);
        node.setLChild(lchild);
        if (null != lchild)
        {
            lchild.setParent(node);
        }
        TreeNode<T> rchild = createTree(seq, mid + 1, end);
        node.setRChild(rchild);
        if (null != rchild)
        {
            rchild.setParent(node);
        }
        
        return node;
    }
    
    public static void main(String[] args)
    {
        Integer[] s = new Integer[] { 1, 2, 4, 5, 8, 9, 11, 14, 17, 19, 22, 25, 29, 33};
        Q4_3<Integer> t = new Q4_3<>(s);
        System.out.println(t);
    }
}
