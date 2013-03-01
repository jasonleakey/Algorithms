package edu.algorithm.datastruct;

public class LinkList
{
    protected Node head;

    // singly linked list.
    public static class Node
    {
        public Object data;

        public Node next;

        public Node(Object d)
        {
            this.data = d;
            this.next = null;
        }
        
        public Node(Node other)
        {
            this.data = other.data;
            this.next = other.next;
        }
        
        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((data == null) ? 0 : data.hashCode());
            result = prime * result + ((next == null) ? 0 : next.hashCode());
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
            if (!(obj instanceof Node))
            {
                return false;
            }
            Node other = (Node) obj;
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
            if (next == null)
            {
                if (other.next != null)
                {
                    return false;
                }
            }
            else if (!next.equals(other.next))
            {
                return false;
            }
            return true;
        }
    }

    public LinkList()
    {
        this.head = null;
    }
    
    public LinkList(Object[] datas)
    {
        if (0 == datas.length)
        {
            this.head = null;
        }
        else
        {
            this.head = new Node(datas[0]);
            Node p = this.head;
            for (int i = 1; i < datas.length; i++)
            {
                p.next = new Node(datas[i]);
                p = p.next;
            }
        }
    }

    public boolean isEmpty()
    {
        return null == head;
    }
    
    public void append(Node nd)
    {
        if (isEmpty())
        {
            head = nd;
            return;
        }
        
        Node p = head;
        while (null != p.next)
        {
            p = p.next;
        }
        p.next = nd;
    }

    public void insertFirst(Node nd)
    {
        nd.next = head;
        head = nd;
    }

    public Node deleteFirst()
    {
        if (isEmpty())
        {
            return null;
        }
        Node tmp = head;
        head = head.next;
        return tmp;
    }
    
    public Node find(Object data)
    {
        Node p = head;
        while (null != p)
        {
            if (p.data.equals(data))
            {
                return p;
            }
            p = p.next;
        }
        
        return null;
    }
    
    @Override
    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        
        Node p = head;
        while (null != p)
        {
            buf.append(String.valueOf(p.data) + '\t');
            p = p.next;
        }
        
        return buf.toString();
    }
    
    public Node head()
    {
        return head;
    }
    
    public LinkList reverse()
    {
        if (isEmpty())
        {
            return null;
        }
        
        LinkList L = new LinkList();
        Node p = head;
        
        while (null != p)
        {
            Node q = new Node(p);
            L.insertFirst(q);
            p = p.next;
        }
        
        return L;
    }
    
    public void reverse_inplace()
    {
        head = reverse(head);
    }
    
    // IF node is null or node is the only element, 
    // ---// THEN return it.
    // REVERSE the sub-LinkList starting from node.next
    // JOIN the reversed sub-LinkList with node.
    // RETURN the head of reversed LinkList.
    private Node reverse(Node node)
    {
        if (null == node || null == node.next)
        {
            return node;
        }
        
        Node p = node.next;
        Node q = reverse(node.next);
        p.next = node;
        node.next = null;
        return q;
    }
    
    public static void main(String[] args)
    {
        LinkList L = new LinkList(new Integer[]{8, 4, 3, 5, 7, 2, 1, 9, 6, 5});
        System.out.println(L);
        L.reverse_inplace();
        System.out.println(L);
    }
}
