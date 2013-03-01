package edu.algorithm.nlp;

/**
 * simplified deterministic finite state automata
 * 
 * @author jasonleakey
 */
public class SimpleDFSA
{
    /*************************************************************************
     * Compilation: javac DFA.java
     * Execution: java DFA
     * Simulate a DFA which recognizes the language of all strings over
     * the binary alphabet { a, b } with a multiple of three a's.
     * % java DFA babbabbb
     * false
     * % java DFA baabbba
     * true
     *************************************************************************/

    public static void main(String[] args)
    {
         String input = "babbabbbbbbbbaaaaa";
//        String input = "babbaba";

        boolean[] accept = { true, false, false };
        int[][] next = { { 1, 0 }, { 2, 1 }, { 0, 2 } };
        int state = 0;
        for (int i = 0; i < input.length(); i++)
        {
            state = next[state][input.charAt(i) - 'a'];
        }
        System.out.println(accept[state]);
    }
}
