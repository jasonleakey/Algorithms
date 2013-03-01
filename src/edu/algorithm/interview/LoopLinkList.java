package edu.algorithm.interview;

import edu.algorithm.datastruct.LinkList;

public class LoopLinkList extends LinkList
{
    public LoopLinkList(Object[] datas)
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
                Node prev = find(datas[i]);
                if (null == prev)
                {
                    p.next = new Node(datas[i]);
                    p = p.next;
                }
                else
                {
                    p.next = prev;
                    p = p.next;
                }
            }
        }
    }
}
