package edu.algorithm.datastruct;

/**
 * Generic Binary Tree
 * 
 * @author jasonleakey
 * 
 */
public class BinTree<T>
{
    /**
     * 树的节点。
     * 
     * @author jasonleakey
     * 
     * @param <U>
     *            节点内容类型。
     */
    public static class TreeNode<U>
    {
        // 结点值
        private U data;

        // 父结点指针。
        private TreeNode<U> parent;

        // 左子树指针。
        private TreeNode<U> lChild;

        // 右子树指针。
        private TreeNode<U> rChild;

        public TreeNode()
        {
            this(null, null, null, null);
        }

        public TreeNode(U value)
        {
            this(value, null, null, null);
        }

        public TreeNode(U value, TreeNode<U> leftChild, TreeNode<U> rightChild,
                TreeNode<U> parent)
        {
            this.data = value;
            this.lChild = leftChild;
            this.rChild = rightChild;
            this.parent = parent;
        }

        /**
         * 设置新的节点值。
         */
        public void setValue(U value)
        {
            this.data = value;
        }

        public U getValue()
        {
            return data;
        }

        /**
         * 设置左子树
         * 
         * @param leftChild
         *            新的左子树
         */
        public void setLChild(TreeNode<U> leftChild)
        {
            this.lChild = leftChild;
        }

        public TreeNode<U> getLChild()
        {
            return lChild;
        }

        /**
         * 设置右子树
         * 
         * @param rightChild
         *            新的右子树
         */
        public void setRChild(TreeNode<U> rightChild)
        {
            this.rChild = rightChild;
        }

        public TreeNode<U> getRChild()
        {
            return rChild;
        }

        /**
         * 节点输出为字符串。
         */
        @Override
        public String toString()
        {
            return data.toString();
        }

        public TreeNode<U> getParent()
        {
            return parent;
        }

        public void setParent(TreeNode<U> parent)
        {
            this.parent = parent;
        }
        
        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((data == null) ? 0 : data.hashCode());
            result = prime * result
                    + ((lChild == null) ? 0 : lChild.hashCode());
            result = prime * result
                    + ((parent == null) ? 0 : parent.hashCode());
            result = prime * result
                    + ((rChild == null) ? 0 : rChild.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null)
            {
                return false;
            }
            if (!(obj instanceof TreeNode))
            {
                return false;
            }
            TreeNode<U> other = (TreeNode<U>) obj;
            if (data == null)
            {
                if (other.data != null)
                {
                    return false;
                }
            }
            else if (!data.equals(other.data))
            {
                return false;
            }
            if (lChild == null)
            {
                if (other.lChild != null)
                {
                    return false;
                }
            }
            else if (!lChild.equals(other.lChild))
            {
                return false;
            }
            if (parent == null)
            {
                if (other.parent != null)
                {
                    return false;
                }
            }
            else if (!parent.equals(other.parent))
            {
                return false;
            }
            if (rChild == null)
            {
                if (other.rChild != null)
                {
                    return false;
                }
            }
            else if (!rChild.equals(other.rChild))
            {
                return false;
            }
            return true;
        }

        public void visit()
        {
            System.out.print(data.toString());
        }
    }

    // 根节点
    public TreeNode<T> root;

    public BinTree()
    {
        root = null;
    }

    public BinTree(T[] data)
    {
        root = createBinTree(data, 0);
    }

    private TreeNode<T> createBinTree(T[] data, int index)
    {
        TreeNode<T> node = null;
        if (index >= data.length || null == data[index])
        {
            node = null;
        }
        else
        {
            node = new TreeNode<>(data[index]);
            TreeNode<T> lnode = createBinTree(data, 2 * index + 1);
            node.setLChild(lnode);
            if (null != lnode)
            {
                lnode.setParent(node);
            }
            TreeNode<T> rnode = createBinTree(data, 2 * index + 2);
            node.setRChild(rnode);
            if (null != rnode)
            {
                rnode.setParent(node);
            }
        }
        return node;
    }
    
    @Override
    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        output(buf, root, 0);
        return buf.toString();
    }
    
    private void output(StringBuilder buf, TreeNode<T> node, int spaces)
    {
        if (null != node)
        {
            output(buf, node.getRChild(), spaces + 5);
            for (int i = 0; i < spaces; i++)
            {
                buf.append(' ');
            }
            buf.append(node.getValue().toString() + '\n');
            output(buf, node.getLChild(), spaces + 5);
        }
        else
        {
            for (int i = 0; i < spaces; i++)
            {
                buf.append(' ');
            }
            buf.append("*\n");
        }
    }
}
