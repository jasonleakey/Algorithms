package edu.algorithm.datastruct;

public class RBTree<T extends Comparable<? super T>> extends BinSearchTree<T>
{
    // 结点颜色类型。
    public enum ColorType
    {
        RED, BLACK
    }

    protected class RBTreeNode<U> extends TreeNode<U>
    {
        // 结点颜色。
        private ColorType color;

        public RBTreeNode()
        {
            this(null, null);
        }

        public RBTreeNode(U value)
        {
            // 默认是红色结点。
            this(value, ColorType.RED);
        }

        public RBTreeNode(U value, ColorType color)
        {
            super(value);
            this.setColor(color);
        }

        public ColorType getColor()
        {
            return color;
        }

        public void setColor(ColorType color)
        {
            this.color = color;
        }
    }

    // nil 空结点，默认黑色。
    private TreeNode<T> nil = new RBTreeNode<T>();

    public RBTree(T[] seq)
    {
        super(seq);
    }

    public void leftRotate(TreeNode<T> x)
    {
        TreeNode<T> y = x.getRChild();

        // 只有在y结点存在时，左旋才有意义。
        if (null != y)
        {
            // y的左子树成为x的右子树
            x.setRChild(y.getLChild());
            if (null != y.getLChild())
            {
                y.getLChild().setParent(x);
            }

            // y替代x的位置。
            y.setParent(x.getParent());
            if (null != x.getParent())
            {
                if (y.getValue().compareTo(x.getParent().getValue()) >= 0)
                {
                    x.getParent().setLChild(y);
                }
                else
                {
                    x.getParent().setRChild(y);
                }
            }
            else
            {
                root = y;
            }

            // x成为y的左子树。
            x.setParent(y);
            y.setLChild(x);
        }
    }

    public void rightRotate(TreeNode<T> x)
    {
        TreeNode<T> y = x.getLChild();

        // 只有在y结点存在时，右旋才有意义。
        if (null != y)
        {
            // y的右子树成为x的左子树
            x.setLChild(y.getRChild());
            if (null != y.getRChild())
            {
                y.getRChild().setParent(x);
            }

            // y替代x的位置。
            y.setParent(x.getParent());
            if (null != x.getParent())
            {
                if (y.getValue().compareTo(x.getParent().getValue()) >= 0)
                {
                    x.getParent().setLChild(y);
                }
                else
                {
                    x.getParent().setRChild(y);
                }
            }
            else
            {
                root = y;
            }

            // x成为y的右子树。
            x.setParent(y);
            y.setRChild(x);
        }
    }

    public void insert(T key)
    {
        TreeNode<T> z = super.iterative_insert(key);

        insertFixup(z);
    }

    private void insertFixup(TreeNode<T> z)
    {
        // while (z.getParent().get)
    }

    public static void main(String[] args)
    {
        String[] strs = { "apple", "able", "doodle", "soup", "zoo", "zebra",
                "woody", "cookie", "look", "book", "juice", "cup", "dwell",
                "light", "mouse", "gutter", "goose", "go", "boss", "look",
                "zemita", "kaka" };
        RBTree<String> rbtree = new RBTree<String>(strs);
        rbtree.leftRotate(rbtree.root);
        rbtree.leftRotate(rbtree.root);
        rbtree.leftRotate(rbtree.root);
        rbtree.leftRotate(rbtree.root);

        rbtree.rightRotate(rbtree.root);
        rbtree.rightRotate(rbtree.root);
        rbtree.rightRotate(rbtree.root);
        rbtree.rightRotate(rbtree.root);
        rbtree.inorderTreeWalk();
    }
}
