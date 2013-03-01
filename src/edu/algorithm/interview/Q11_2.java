package edu.algorithm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q11_2
{
    public static void sortAnagram(String[] arr)
    {
        HashMap<String, List<String>> table = new HashMap<String, List<String>>();
        for (int i = 0; i < arr.length; i++)
        {
            char[] origChars = arr[i].toCharArray();
            Arrays.sort(origChars);
            String str2 = new String(origChars);
            if (table.containsKey(str2))
            {
                List<String> L = table.get(str2);
                L.add(arr[i]);
            }
            else
            {
                List<String> L = new ArrayList<String>();
                L.add(arr[i]);
                table.put(str2, L);
            }
        }

        int k = 0;
        for (List<String> L : table.values())
        {
            for (String str : L)
            {
                arr[k++] = str;
            }
        }
    }

    public static void main(String[] args)
    {
        String[] arr = new String[] { "guagelan", "eat", "swho", "up",
                "wonder", "tea", "shoow", "gonbi", "oogd", "dogo", "dernow",
                "push", "good", "language", "yabb", "woosh", "abby", "show",
                "bbay", "bingo", "bunny", "baby", "cup", "shup", "stop",
                "gdoo", "swooh", "pu", "doo", "phsu" };
        sortAnagram(arr);
        for (String str : arr)
        {
            System.out.print(str + ", ");
        }
    }
}
