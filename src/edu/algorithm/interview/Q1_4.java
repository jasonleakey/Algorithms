package edu.algorithm.interview;


public class Q1_4
{
    public static void replace(char[] str, int len)
    {
        int i = 0;
        int k = 0; 
        int j = 0;
        
        while (j < len)
        {
            if (' ' != str[i])
            {
                j++;
            }
            else if (j != 0 && ' ' != str[i + 1])
            {
                j++;
                k++;
            }
            
            i++;
        }
        
        j = len + 2 * k;
        str[j] = '\0';
        i--;
        j--;
        
        while (i >=0 && j >= 0)
        {
            if (' ' != str[i])
            {
                str[j--] = str[i];
            }
            else if (j != 0 && ' ' != str[i + 1])
            {
                str[j--] = '0';
                str[j--] = '2';
                str[j--] = '%';
            }
            i--;
        }
    }
    
    // some bugs in the solution. 
    public static void replaceSpaces(char[] str, int length)
    {
        int spaceCount = 0;
        int newLength = 0;
        int i = 0;
        for (i = 0; i < length; i++)
        {
            if (' ' == str[i])
            {
                spaceCount++;
            }
        }
        
        newLength = length + spaceCount * 2;
        str[newLength] = '\0';
        
        for (i = length - 1; i >= 0; i--)
        {
            if (' ' == str[i])
            {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            }
            else
            {
                str[newLength - 1] = str[i];
                newLength -= 1;
            }
        }
    }
    
    public static void main(String[] args)
    {
        char[] str = new char[50];
//        String sent = "   Hint  Mr   John Smith    ";
        String sent = "Mr   John Smith    ";
        System.arraycopy(sent.toCharArray(), 0, str, 0, sent.length());
        
        replaceSpaces(str, 13);
        System.out.println(str);
    }
}
