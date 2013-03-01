package edu.algorithm.interview;

import edu.algorithm.datastruct.LinkList;
import edu.algorithm.datastruct.LinkList.Node;

public class Q2_5
{
    public static LinkList sum(LinkList L1, LinkList L2)
    {
        if (null == L1 || L1.isEmpty() || null == L2 || L2.isEmpty())
        {
            return null;
        }
        
        LinkList L3 = new LinkList();
        Node p1 = L1.head();
        Node p2 = L2.head();
        int carry = 0;
        
        while (0 != carry || null != p1 || null != p2)
        {
            int result = 0;
            if (null != p1)
            {
                result += (Integer) p1.data;
                p1 = p1.next;
            }
            
            if (null != p2)
            {
                result += (Integer) p2.data;
                p2 = p2.next;
            }
            result += carry;
            
            carry = result / 10;
            int q = result % 10;
            L3.append(new Node(Integer.valueOf(q)));
        }
        
        return L3;
    }
    
    public static LinkList sum_r(LinkList L1, LinkList L2)
    {
        LinkList L1_r = L1.reverse();
        LinkList L2_r = L2.reverse();
        LinkList L3_r = sum(L1_r, L2_r);
        return L3_r.reverse();
    }
    
    public static void main(String[] args)
    {
        Integer[] l1 = {7, 1, 7};
        Integer[] l2 = {5, 9, 2};
        LinkList L1 = new LinkList(l1);
        LinkList L2 = new LinkList(l2);

        System.out.println(sum_r(L1, L2));
    }
}
