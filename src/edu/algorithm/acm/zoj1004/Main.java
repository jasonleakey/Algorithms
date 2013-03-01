package edu.algorithm.acm.zoj1004;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main
{
    private char[] inputStr;

    private char[] outputStr;

    private Stack<String> stack = new Stack<String>();

    private List<String> result = new ArrayList<String>();

    public Main(String in, String out)
    {
        this.inputStr = in.toCharArray();
        this.outputStr = out.toCharArray();

    }

    // dfs with backtrace. 
    // two pointers: 
    // i - for the input string.
    // j - for the output string.
    public void dfs(int i, int j)
    {
        // all characters of the output string processed. 
        if (j == outputStr.length)
        {
            // output a result
            output();
            return;
        }
        
        // move one step forward in the input string.
        if (i < inputStr.length)
        {
            // push one character into stack.
            stack.push(String.valueOf(inputStr[i]));
            result.add("i");
            // begin recursion to next character 
            dfs(i + 1, j);
            
            // restore environment.  
            result.remove(result.size() - 1);
            stack.pop();
        }

        // check the stack. 
        if (!stack.isEmpty()
                && stack.peek().equals(String.valueOf(outputStr[j])))
        {
            // pop the stack only if the top element equals the current character of input string. 
            String c = stack.pop();
            result.add("o");
            // one character matched. 
            dfs(i, j + 1);

            // restore environment.
            stack.push(c);
            result.remove(result.size() - 1);
        }
    }

    void output()
    {
        for (int i = 0; i < result.size(); i++)
        {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine())
        {
            String in = scan.nextLine();
            String out = scan.nextLine();
            Main anagram = new Main(in, out);
            System.out.println("[");
            anagram.dfs(0, 0);
            System.out.println("]");
        }
    }
}
