package edu.algorithm.interview;

public class Q11_3
{
    public static int find(int[] arr, int t)
    {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] == t)
            {
                return mid;
            }
            else if (t > arr[high] || (arr[mid] <= arr[high] && t < arr[mid]))
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args)
    {
//        int[] arr = new int[] {15, 16, 19, 20, 25, 30, 33, 35, 1, 3, 4, 5, 7, 10, 14};
        int[] arr = new int[] {15, 15, 19, 20, 25, 30, 33, 35, 1, 3, 4, 5, 7, 10, 14, };
        System.out.println(find(arr, 15));
    }
}
