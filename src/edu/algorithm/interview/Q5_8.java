package edu.algorithm.interview;

public class Q5_8
{
    public static void drawHorizontalLine(byte[] screen, int width, int x1,
            int x2, int y)
    {
        if (x1 >= width || x2 >= width)
        {
            // invalid input
            return;
        }
        if (x1 >= x2)
        {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        int start = y * width / 8 + x1 / 8;
        int end = y * width / 8 + x2 / 8;

        for (int k = start + 1; k < end; k++)
        {
            screen[k] = (byte) 0xff;
        }

        if (start != end)
        {
            screen[start] |= ((1 << (8 - x1 % 8)) - 1);
            screen[end] |= ((~0) << (8 - x2 % 8 - 1));
        }
        else
        {
            screen[start] |= (((1 << (x2 - x1 + 1)) - 1) << (8 - x2 % 8 - 1));
        }
    }

    public static void main(String[] args)
    {
        int width = 48;
        byte[] screen = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
        drawHorizontalLine(screen, width, 1, 46, 2);
        for (int i = 0; i < screen.length / (width / 8); i++)
        {
            for (int j = 0; j < width / 8; j++)
            {
                System.out
                        .print(String
                                .format("%8s",
                                        Integer.toBinaryString(screen[i * width
                                                / 8 + j] & 0xff)).replace(' ',
                                        '0'));
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
