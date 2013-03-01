package edu.algorithm.interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FrequentTerms
{
    public static void freqTerm(String[] A, int k)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < A.length; i++)
        {
            if (map.containsKey(A[i]))
            {
                map.put(A[i], map.get(A[i]) + 1);
            }
            else
            {
                map.put(A[i], 1);
            }
        }
        ValueComparator valComp = new ValueComparator(map);
        TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(
                valComp);
        sortedMap.putAll(map);
        Iterator<String> iter = sortedMap.keySet().iterator();
        for (int i = 0; i < k; i++)
        {
            System.out.println(iter.next());
        }
    }

    private static class ValueComparator implements Comparator<String>
    {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> map)
        {
            this.base = map;
        }

        @Override
        public int compare(String a, String b)
        {
            if (base.get(a) > base.get(b))
            {
                return -1;
            }
            else if (base.get(a) < base.get(b))
            {
                return 1;
            }
            else
            {
                return a.compareToIgnoreCase(b);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String[] A = new String[N];
        scan.nextLine();
        for (int i = 0; i < N; i++)
        {
            A[i] = scan.nextLine();
        }
        int k = scan.nextInt();
        freqTerm(A, k);
        scan.close();
    }
}
