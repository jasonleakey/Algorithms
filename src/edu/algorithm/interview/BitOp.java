package edu.algorithm.interview;

public class BitOp
{
    public static int getBit(int num, int i)
    {
        return (0 != (num & (1 << i))) ? 1 : 0;
    }

    public static int setBit(int num, int i)
    {
        return num | (1 << i);
    }

    public static int clearBit(int num, int i)
    {
        int mask = ~(1 << i);
        return num & mask;
    }

    public static int clearBitsMSBthroughI(int num, int i)
    {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    public static int clearBitsIthrough0(int num, int i)
    {
        int mask = ~((1 << (i + 1)) - 1);
        return num & mask;
    }

    public static int updateBit(int num, int i, int v)
    {
        int mask = ~(1 << i);
        return (num & mask) | (v << i);
    }

    public static String toString(int num)
    {
        return "Decimal[" + num + "], Hex[0x" + Integer.toHexString(num)
                + "], Binary[" + Integer.toBinaryString(num) + "], Octal["
                + Integer.toOctalString(num) + "]";
    }

    public static void main(String[] args)
    {
        int a = 1000;
        int b = 0;
        System.out.println(Integer.toBinaryString(a));
        b = getBit(a, 6);
        System.out.println("Bit at POSITION 6: " + b);
        b = setBit(a, 4);
        System.out.println("Decimal: " + b + ", Binary: "
                + Integer.toBinaryString(b));
        b = clearBit(a, 5);
        System.out.println("Decimal: " + b + ", Binary: "
                + Integer.toBinaryString(b));
        b = clearBitsMSBthroughI(a, 7);
        System.out.println("Decimal: " + b + ", Binary: "
                + Integer.toBinaryString(b));
        b = clearBitsIthrough0(a, 7);
        System.out.println("Decimal: " + b + ", Binary: "
                + Integer.toBinaryString(b));
    }
}
