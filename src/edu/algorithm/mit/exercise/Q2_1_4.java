package edu.algorithm.mit.exercise;


public class Q2_1_4
{
    public static String binIntSum(String A, String B, int base)
    {
        if (null == A || null == B || A.length() <= 0 || B.length() <= 0
                || A.length() != B.length())
        {
            return null;
        }

        // 字符串格式进行位处理
        StringBuffer C = new StringBuffer();
        // 进位
        int carryBit = 0;
        // binary integer的长度
        int n = A.length();
        // 从最低位到最高位。
        for (int i = n - 1; i >= 0; i--)
        {
            // 第i位相加
            int tmp = Integer.parseInt(A.charAt(i) + "") + Integer.parseInt(B.charAt(i) + "") + carryBit;
            // 得到C的第i位。
            C.insert(0, tmp % base);
            // 计算进位。
            carryBit = tmp / base;
        }
        // 最高位为进位值。
        if (carryBit != 0)
        {
            C.insert(0, carryBit);
        }
        
        return C.toString();
    }
    
    
    
    public static void main(String[] args)
    {
        String A = "10101101";
        String B = "01101110";
        String C = binIntSum(A, B, 2);
        System.out.println(C);
        String D = "28461875";
        String E = "88935197";
        String F = binIntSum(D, E, 10);
        System.out.println(F);
    }
}
