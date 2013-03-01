package edu.algorithm.acm.zoj1006;

import java.util.Scanner;

public class Main
{
    public static String decode(String inputtext, int k)
    {
        char[] ciphertext = inputtext.toCharArray();
        // the length of message
        int n = ciphertext.length;
        
        char[] plaintext = new char[n];
        for (int i = 0; i < n; i++)
        {
            plaintext[(k * i) % n] = code_to_text((text_to_code(ciphertext[i]) + i) % 28);
        }
        
        return String.copyValueOf(plaintext);
    }
    
    private static final char code_to_text(int code)
    {
        
        if (0 == code)
        {
            return '_';
        }
        else if (27 == code)
        {
            return '.';
        }
        else if (code > 0 && code < 27)
        {
            // ASCII 'a' = 97, 'z' = 122
            return (char) (code + 96);
        }
        else
        {
            return ' ';
        }
    }
    
    private static final int text_to_code(char text)
    {
        
        if ('_' == text)
        {
            return 0;
        }
        else if ('.' == text)
        {
            return 27;
        }
        else 
        {
            // ASCII 'a' = 97, 'z' = 122
            return text - 96;
        }
    }
    

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt())
        {
            int key = scan.nextInt();
            if (0 == key)
            {
                return;
            }
            
            String ciphertext = scan.next();
            
            System.out.println(Main.decode(ciphertext, key));
        }
    }
}
