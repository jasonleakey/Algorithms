package edu.algorithm.interview;

import edu.algorithm.datastruct.LinkList;
import edu.algorithm.datastruct.LinkList.Node;

public class Q2_3
{
    public static void delMid(LinkList L)
    {
        Node p1 = L.head();
        Node p2 = L.head();
        Node p3 = L.head();

        while (null != p2 && null != p2.next)
        {
            p3 = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        p3.next = p1.next;
    }
    
    // given only access to that node.
    public static void delMid2(Node mid)
    {
        if (null != mid && null != mid.next)
        {
            mid.data = mid.next.data;
            mid.next = mid.next.next;
        }
    }

    public static void main(String[] args)
    {
        String[] strs = { "c", "b", "k", "j", "x", "y", "z", "g", "h", "d",
                "l" };
        LinkList L = new LinkList(strs);

        Node y = L.find("y");
        delMid2(y);
        System.out.println(L);
    }
}
