package edu.algorithm.combinatorics;

import java.util.Arrays;

import edu.algorithm.acm.DuplicateElemTest;

/**
 * 全排列序列生成器
 * 算法描述：
 * Begin with 1←2←...n←
 * While there exists a mobile integer, do
 * 1) Find the largest mobile integer m;
 * 2) Switch m and the adjacent integer its arrow points to
 * 3) Switch the direction of all integers p with p>m
 */
public class PermGenerator
{
    // 方向类型，向左，向右。
    enum Direction
    {
        LEFT, RIGHT
    }

    class DirectedNumber
    {
        // 数字
        public int num;

        // 方向
        public Direction direct;

        // 是否是mobile integer
        public boolean isMobile;

        public DirectedNumber()
        {

        }
    }

    public void printPerm(int[] arr)
    {
        if (DuplicateElemTest.checkDuplicate_1(arr))
        {
            System.err.println("错误：不能有重复的数字！");
            return;
        }
        
        // 排序
        Arrays.sort(arr);

        // 构建初始数组
        DirectedNumber[] directArr = new DirectedNumber[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            directArr[i] = new DirectedNumber();
            directArr[i].num = arr[i];
            directArr[i].direct = Direction.LEFT;
            directArr[i].isMobile = true;
        }
        directArr[0].isMobile = false;

        for (;;)
        {
            // 先输出当前排列
            for (DirectedNumber dn : directArr)
            {
                System.out.print(dn.num);
            }
            System.out.println();

            // 查找最大Mobile Integer
            int max = 0;
            // 最大Mobile Integer的下标
            int idx = -1;
            for (int i = 0; i < arr.length; i++)
            {
                if (directArr[i].isMobile && directArr[i].num >= max)
                {
                    idx = i;
                    max = directArr[i].num;
                }
            }

            // 没有Mobile Integer，说明全排列完成
            if (-1 == idx)
            {
                break;
            }

            // Switch m and the adjacent integer its arrow points to
            if (Direction.LEFT == directArr[idx].direct)
            {
                DirectedNumber temp = directArr[idx];
                directArr[idx] = directArr[idx - 1];
                directArr[idx - 1] = temp;
            }
            else
            {
                DirectedNumber temp = directArr[idx];
                directArr[idx] = directArr[idx + 1];
                directArr[idx + 1] = temp;
            }

            // Switch the direction of all integers p with p>m
            for (DirectedNumber dn : directArr)
            {
                if (dn.num > max)
                {
                    if (Direction.LEFT == dn.direct)
                    {
                        dn.direct = Direction.RIGHT;
                    }
                    else
                    {
                        dn.direct = Direction.LEFT;
                    }
                }
            }

            // 重置是否是Mobile Integer
            for (int i = 0; i < arr.length; i++)
            {
                // 当前数字方向为左
                if (Direction.LEFT == directArr[i].direct)
                {
                    // 该数字不是最左边，而且比左边的值要大，则是Mobile
                    if (i - 1 >= 0 && directArr[i].num > directArr[i - 1].num)
                    {
                        directArr[i].isMobile = true;
                    }
                    else
                    {
                        // 该数字已经是最左边，则不是Mobile
                        directArr[i].isMobile = false;
                    }
                }

                // 当前数字方向为右
                else
                {
                    // 数字不是最右边，而且比右边的值要大，则是mobile
                    if (i + 1 < arr.length
                            && directArr[i].num > directArr[i + 1].num)
                    {

                        directArr[i].isMobile = true;
                    }
                    else
                    {
                        // 该数字已经在最右边，则不是mobile
                        directArr[i].isMobile = false;

                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {

        int[] arr = { 1, 4, 3, 6, 5};
        PermGenerator pg = new PermGenerator();
        pg.printPerm(arr);
    }
}