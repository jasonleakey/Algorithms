package edu.algorithm.interview;

import edu.algorithm.datastruct.LinkList;
import edu.algorithm.datastruct.LinkList.Node;


public class Q2_2
{
    // UNKNOWN linked list length, i.e. no size() method
    public static Object getElem(LinkList L, int k)
    {
        if (k <= 0)
        {
            return null;
        }
        
        Node p1 = L.head();
        Node p2 = L.head();
        
        for (int i = 0; i < k && null != p2; i++)
        {
            p2 = p2.next;
        }
        
        if (null == p2)
        {
            return null;
        }
        
        while (null != p2)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1.data;
    }
    
    public static void main(String[] args)
    {
        String[] strs = {"c", "b", "k", "j", "x", "y", "z", "g", "h", "d", "l", "v"};
        LinkList L = new LinkList(strs);
        
        System.out.println((String) getElem(L, 4));
    }
}
