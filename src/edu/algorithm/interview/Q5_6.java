package edu.algorithm.interview;

public class Q5_6
{
    public static int swapBits(int num)
    {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }
    
    public static void main(String[] args)
    {
        int num = 0b01100101010011000111;
        System.out.println(BitOp.toString(num));
        System.out.println(BitOp.toString(swapBits(num)));
    }
}
