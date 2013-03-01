package edu.algorithm.interview;

import edu.algorithm.datastruct.LinkList;
import edu.algorithm.datastruct.LinkList.Node;

public class Q2_4
{
    public static void partition(LinkList L, int x)
    {
        Node p1 = L.head();
        Node p2 = L.head().next;
        
        while (null != p2)
        {
            if ((Integer) p2.data < x)
            {
                // delete this node.
                p1.next = p2.next;
                // and insert it to the head of linklist.
                L.insertFirst(p2);
                p2 = p1.next;
            }
            else
            {
                p1 = p2;
                p2 = p2.next;
            }
        }
    }
    
    public static void main(String[] args)
    {
        Integer[] strs = {3, 7, 12, -3, 0, 9, 4, 8, 5, 17, -6, -9, 10, -2, 1, -1, -4};
        LinkList L = new LinkList(strs);

//        Node y = L.find("y");
        partition(L, 4);
        System.out.println(L);
    }
}
