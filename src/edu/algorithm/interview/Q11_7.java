package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q11_7
{
    private static class Person 
    {
        public int height;

        public int weight;

        public Person(int height, int weight)
        {
            this.height = height;
            this.weight = weight;
        }
        
        public boolean smaller(Person other)
        {
            return (this.height < other.height && this.weight < other.weight);
        }
        
        @Override
        public String toString()
        {
            return "(" + height + "," + weight + ")";
        }
    }

    // T: O(n^3); S: O(n^2)
    public static void tower(Person[] pers)
    {
        List<List<Person>> L = new ArrayList<List<Person>>();
        List<Person> max = null;
        for (int i = 0; i < pers.length; i++)
        {
            List<Person> p = new LinkedList<Person>();
            p.add(pers[i]);
            for (int j = 0; j < pers.length; j++)
            {
                int k = 0;
                for (; k < p.size() && p.get(k).smaller(pers[j]); k++)
                {
                    ;
                }
                if (k < p.size())
                {
                    p.add(k, pers[j]);
                }
            }
            L.add(p);
            if (null == max || p.size() > max.size())
            {
                max = p;
            }
        }
        for (Person p : max)
        {
            System.out.print("(" + p.height + "," + p.weight + ") ");
        }
    }
    
    public static void tower2(Person[] A)
    {
        // sort persons by height
        // insertion sort
        for (int i = 1; i < A.length; i++)
        {
            if (A[i].height < A[i - 1].height)
            {
                Person temp = A[i];
                int j = i - 1;
                for (; j >= 0 && A[j].height > temp.height; j--)
                {
                    A[j + 1] = A[j];
                }
                A[j + 1] = temp;
            }
        }
        
        // calculate longest increasing subsequence by weight
        int[] len = new int[A.length];
        ArrayList<ArrayList<Person>> result = new ArrayList<ArrayList<Person>>();
        for (int i = 0; i < A.length; i++)
        {
            len[i] = 1; 
            ArrayList<Person> lis = new ArrayList<Person>();
            for (int j = 0; j < i; j++)
            {
                if (A[j].weight < A[i].weight &&
                    len[j] + 1 > len[i])
                {
                    len[i] = len[j] + 1;
                    lis.clear();
                    lis.addAll(result.get(j));
                }
            }
            lis.add(A[i]);
            result.add(lis);
        }
        
        int max = 0;
        for (int i = 0; i < A.length; i++)
        {
            if (len[i] > len[max])
            {
                max = i;
            }
        }
        System.out.println(result.get(max));
    }

    public static void main(String[] args)
    {
        Person[] pers = new Person[9];
        pers[0] = new Person(65, 100);
        pers[1] = new Person(70, 150);
        pers[2] = new Person(62, 105);
        pers[3] = new Person(56, 90);
        pers[4] = new Person(75, 190);
        pers[5] = new Person(60, 95);
        pers[6] = new Person(68, 110);
        pers[7] = new Person(80, 170);
        pers[8] = new Person(78, 180);
        
        tower2(pers);
    }
}
