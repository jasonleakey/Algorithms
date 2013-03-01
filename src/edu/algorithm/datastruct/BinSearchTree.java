package edu.algorithm.datastruct;

/**
 * Binary Search Tree
 * Operation : SEARCH, MINIMUM, MAXIMUM,
 * PREDECESSOR, SUCCESSOR, INSERT, DELETE
 * 
 * @author jasonleakey
 */
public class BinSearchTree<T extends Comparable<? super T>> extends BinTree<T>
{
    /**
     * 中序递归遍历以key为根的树。
     * 
     * @param key
     */
    public void inorderTreeWalk()
    {
        inorderTreeWalk(root);
        System.out.println();
    }

    private void inorderTreeWalk(TreeNode<T> node)
    {
        if (null != node)
        {
            inorderTreeWalk(node.getLChild());
            node.visit();
            System.out.print("*");
            inorderTreeWalk(node.getRChild());
        }
    }

    public void insert(T key)
    {
        root = insert(root, key);
    }

    public BinSearchTree()
    {
    }
    
    public BinSearchTree(T[] seq)
    {
        super(seq);
    }

    /**
     * 递归插入结点。
     * @return 新的结点。
     */
    private TreeNode<T> insert(TreeNode<T> node, T key)
    {
        if (null == node)
        {
            return new TreeNode<T>(key);
        }

        // 新增加的节点值小于当前结点，插入其左子树
        if (key.compareTo(node.getValue()) < 0)
        {
            TreeNode<T> temp = insert(node.getLChild(), key);
            node.setLChild(temp);
            temp.setParent(node);
        }
        else
        {
            TreeNode<T> temp = insert(node.getRChild(), key);
            node.setRChild(temp);
            temp.setParent(node);
        }

        return node;
    }

    /**
     * 迭代插入结点。
     * @return 新的结点。
     */
    protected TreeNode<T> iterative_insert(T key)
    {
        TreeNode<T> node = root;

        TreeNode<T> parent = null;
        // 寻找插入点。
        while (null != node)
        {
            // 往左走。
            if (key.compareTo(node.getValue()) < 0)
            {
                parent = node;
                node = node.getLChild();
            }
            // 往右走。
            else
            {
                parent = node;
                node = node.getRChild();
            }
        }

        node = new TreeNode<T>(key);
        // 如果是空树。
        if (null == parent)
        {
            root = node;
        }
        else // 不是空树。
        {
            // 新结点比父结点小，插入左子树。
            if (node.getValue().compareTo(parent.getValue()) < 0)
            {
                parent.setLChild(node);
                node.setParent(parent);
            }
            // 新结点比父结点大，插入右子树。
            else 
            {
                parent.setRChild(node);
                node.setParent(parent);
            }
        }
        return node;
    }
    
    /**
     * 删除结点
     * @return 删除的结点的位置。
     */
    public TreeNode<T> delete(TreeNode<T> node)
    {
        TreeNode<T> spliceNode = null;
        TreeNode<T> childNode = null;
        // 如果目标结点至多有一颗子树
        if (null == node.getLChild() || null == node.getRChild())
        {
            spliceNode = node;
        }
        else
        {
            spliceNode = successor(node);
        }
        
        
        if (null != spliceNode.getLChild())
        {
            childNode = spliceNode.getLChild();
        }
        else
        {
            childNode = spliceNode.getRChild();
        }
        
        if (null != childNode)
        {
            childNode.setParent(spliceNode.getParent());
        }
        
        if (null == spliceNode.getParent())
        {
            root = childNode;
        }
        else
        {
            if (spliceNode.getParent().getLChild() == spliceNode)
            {
                spliceNode.getParent().setLChild(childNode);
            }
            else
            {
                spliceNode.getParent().setRChild(childNode);
            }
        }
        
        if (spliceNode != node)
        {
            node.setValue(spliceNode.getValue());
        }
        
        return spliceNode;
    }

    /**
     * 递归搜索节点。
     * 
     * @param key
     *            关键字
     * @return
     */
    public TreeNode<T> search(T key)
    {
        TreeNode<T> node = search(root, key);
        return node;
    }

    private TreeNode<T> search(TreeNode<T> node, T key)
    {
        if (null == node || key.compareTo(node.getValue()) == 0)
        {
            return node;
        }

        if (key.compareTo(node.getValue()) < 0)
        {
            return search(node.getLChild(), key);
        }
        else
        {
            return search(node.getRChild(), key);
        }
    }

    /**
     * 二叉树迭代搜索。
     * 
     * @param key
     *            搜索关键字。
     * @return 二叉树的节点。
     */
    public TreeNode<T> iterative_search(T key)
    {
        TreeNode<T> node = root;
        while (null != node && key.compareTo(node.getValue()) != 0)
        {
            if (key.compareTo(node.getValue()) < 0)
            {
                node = node.getLChild();
            }
            else
            {
                node = node.getRChild();
            }
        }
        return node;
    }

    /**
     * 二叉查找树的最大值。
     */
    public TreeNode<T> max()
    {
        return max(root);
    }

    // 以某结点为根结点的树的最大值。
    private TreeNode<T> max(TreeNode<T> node)
    {
        while (null != node.getRChild())
        {
            node = node.getRChild();
        }

        return node;
    }

    /**
     * 二叉查找树的最小值。
     */
    public TreeNode<T> min()
    {
        return min(root);
    }

    // 以某结点为根结点的树的最小值。
    private TreeNode<T> min(TreeNode<T> node)
    {
        while (null != node.getLChild())
        {
            node = node.getLChild();
        }

        return node;
    }

    /**
     * 当前结点的后继结点。
     */
    public TreeNode<T> successor(TreeNode<T> node)
    {
        // 如果该结点有右子树，则右子树的最小结点是当前结点的后继结点。
        if (null != node.getRChild())
        {
            return min(node.getRChild());
        }

        // 当前结点无右子树，则寻找祖先结点。
        TreeNode<T> parent = node.getParent();
        while (null != parent && parent.getRChild() == node)
        {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    /**
     * 当前结点的前趋结点。
     */
    public TreeNode<T> predecessor(TreeNode<T> node)
    {
        // 如果该结点有左子树，则左子树的最大结点是当前结点的前趋结点。
        if (null != node.getLChild())
        {
            return max(node.getLChild());
        }

        // 当前结点无左子树，则寻找祖先结点。
        TreeNode<T> parent = node.getParent();
        while (null != parent && parent.getLChild() == node)
        {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public static void main(String[] args)
    {
        String[] strs = { "apple", "able", "doodle", "soup", "zoo", "zebra",
                "woody", "cookie", "look", "book", "juice", "cup", "dwell",
                "light", "mouse", "gutter", "goose", "go", "boss", "look",
                "zemita", "kaka" };
        BinSearchTree<String> tree = new BinSearchTree<String>(strs);
        tree.inorderTreeWalk();
        tree.search("zebra");
        tree.iterative_search("juicee");
        System.out.println("最大值：" + tree.max());
        System.out.println("最小值：" + tree.min());

        System.out.println("前趋结点："
                + tree.predecessor(tree.search("go")).getValue());
        System.out.println("后继结点："
                + tree.successor(tree.search("go")).getValue());
        
        tree.delete(tree.search("book"));
        tree.inorderTreeWalk();
    }
}
