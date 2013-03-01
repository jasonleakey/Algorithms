package edu.algorithm.interview;

public class Q11_5
{
    public static int search(String[] arr, String target)
    {
        return search(arr, target, 0, arr.length - 1);
    }
    
    private static int search(String[] arr, String target, int low, int high)
    {
        if (low <= high)
        {
            int mid = (low + high) / 2;
            // FOUND it
            if (target.equals(arr[mid]))
            {
                return mid;
            }
            // MID is empty string, should search both side. 
            else if ("".equals(arr[mid]))
            {
                // SEARCH left
                int result = search(arr, target, low, mid - 1);
                if (-1 != result)
                {
                    return result;
                }
                // SEARCH right
                result = search(arr, target, mid + 1, high);
                if (-1 != result)
                {
                    return result;
                }
            }
            // MID is not empty string, search either left or right.
            else if (arr[mid].compareTo(target) < 0)
            {
                return search(arr, target, mid + 1, high);
            }
            else
            {
                return search(arr, target, low, mid - 1);
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args)
    {
        String[] arr = new String[] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
        System.out.println(search(arr, "ball"));
        System.out.println(search(arr, ""));
    }
}
