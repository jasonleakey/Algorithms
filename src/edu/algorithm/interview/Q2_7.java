package edu.algorithm.interview;

import java.util.Stack;

import edu.algorithm.datastruct.LinkList;
import edu.algorithm.datastruct.LinkList.Node;

public class Q2_7
{
    public static boolean isPalindrome(LinkList L)
    {
        LinkList L2 = L.reverse();
        Node p1 = L.head();
        Node p2 = L2.head();
        while (null != p1)
        {
            if (!p1.data.equals(p2.data))
            {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
    
    public static boolean isPalindrome2(LinkList L)
    {
        Node slowPointer = L.head();
        Node fastPointer = L.head();
        Stack<Object> s = new Stack<>();
        
        while (null != fastPointer && null != fastPointer.next)
        {
            s.push(slowPointer.data);
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        // odd number of elements, so skip the middle node.
        if (null != fastPointer)
        {
            slowPointer = slowPointer.next;
        }
        
        while (null != slowPointer)
        {
            if (!s.pop().equals(slowPointer.data))
            {
                return false;
            }
            slowPointer = slowPointer.next;
        }
        
        return true;
    }

    public static void main(String[] args)
    {
        String[] l1 = { "A", "B", "C", "7", "7", "C", "B", "A" };
//        String[] l1 = { "A", "B", "C", "7", "C", "B", "A" };
        LinkList L1 = new LinkList(l1);

        System.out.println(isPalindrome2(L1));
    }
}
