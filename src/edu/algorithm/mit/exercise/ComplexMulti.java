package edu.algorithm.mit.exercise;

public class ComplexMulti
{
    public static class Complex
    {
        // real part
        private int re;

        // imaginary part
        private int im;

        public Complex(int real, int imaginary)
        {
            this.setReal(real);
            this.setImaginary(imaginary);
        }

        public int real()
        {
            return re;
        }

        public void setReal(int re)
        {
            this.re = re;
        }

        public int imaginary()
        {
            return im;
        }

        public void setImaginary(int im)
        {
            this.im = im;
        }

        @Override
        public String toString()
        {
            if (im < 0)
            {
                return re + String.valueOf(im) + "i";
            }
            else
            {
                return re + "+" + im + "i";
            }
        }
    }

    public static Complex multiply(Complex[] T)
    {
        return multiply(T, 0, T.length - 1);
    }

    private static Complex multiply(Complex[] T, int low, int high)
    {
        if (low == high)
        {
            return T[low];
        }
        if (low < high)
        {
            int mid = (low + high) / 2;
            Complex M1 = multiply(T, low, mid);
            Complex M2 = multiply(T, mid + 1, high);
            int A = M1.re * M2.re;
            int B = M1.im * M2.im;
            int C = (M1.re + M1.im) * (M2.re + M2.im) - (A + B);
            return new Complex(A - B, C);
        }
        return null;
    }

    public static void main(String[] args)
    {
        Complex[] T = new Complex[7];
        T[0] = new Complex(3, 5);
        T[1] = new Complex(-2, 1);
        T[2] = new Complex(4, -3);
        T[3] = new Complex(6, 4);
        T[4] = new Complex(0, -7);
        T[5] = new Complex(-5, 1);
        T[6] = new Complex(-1, -3);
        System.out.println(multiply(T));
    }
}
