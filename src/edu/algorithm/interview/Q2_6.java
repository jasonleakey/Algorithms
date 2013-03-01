package edu.algorithm.interview;

import edu.algorithm.datastruct.LinkList;
import edu.algorithm.datastruct.LinkList.Node;

public class Q2_6
{
    public static Node detectLoopBegin(LinkList L)
    {
        if (null == L || L.isEmpty())
        {
            return null;
        }

        Node slowPointer = L.head();
        Node fastPointer = L.head();

        do
        {
            if (null == fastPointer || null == fastPointer.next)
            {
                System.err.println("No Loop.");
                return null;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        while (!slowPointer.equals(fastPointer));

        slowPointer = L.head();
        while (!slowPointer.equals(fastPointer))
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return fastPointer;
    }

    public static void main(String[] args)
    {
        String[] l1 = { "X", "A", "B", "C", "D", "E", "F" };
        LinkList L1 = new LoopLinkList(l1);

        Node p = detectLoopBegin(L1);
        if (null != p)
        {
            System.out.println((String) detectLoopBegin(L1).data);
        }
    }

}
