package edu.algorithm.acm.zoj1005;

import java.util.Scanner;

public class Main
{
    // the premise is only the case jug A and jug B
    // have relatively prime capacities. 
    public static void solve_jug(int Ca, int Cb, int N)
    {
        int a = 0;
        int b = 0;
        while (true)
        {
            // if jug A is empty, fill jug A
            if (a == 0)
            {
                a = Ca;
                System.out.println("fill A");
            }
            
            // pour A to B
            System.out.println("pour A B");
            int temp = b;
            b = a + b >= Cb ? Cb : (a + b);
            a = Cb - temp >= Ca ? 0 : (a - (Cb - temp));
            
            // if Jug B contains the target volume of water. 
            // return;
            if (b == N)
            {
                System.out.println("success");
                return;
            }
            
            // or if Jug B is full, empty it.
            if (b == Cb)
            {
                System.out.println("empty B");
                b = 0;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt())
        {
            int Ca = scan.nextInt();
            int Cb = scan.nextInt();
            int N = scan.nextInt();
            Main.solve_jug(Ca, Cb, N);
        }
    }
}
