/*
 * MultiplyExceptSelf.c
 *
 *  Created on: Feb 4, 2013
 *      Author: jasonleakey
 */

#include <stdio.h>
#include <stdlib.h>

void multiply(int* A, int n)
{
    long long result = 1L;
    int zeroCnt = 0;
    int i = 0;
    int zeroMark = 0;
    for (i = 0; i < n; i++)
    {
        if (0 == A[i])
        {
            zeroMark = i;
            zeroCnt++;
            if (zeroCnt >= 2)
            {
                result = 0;
                break;
            }
        }
        else
        {
            result *= A[i];
        }
    }

    if (zeroCnt >= 2)
    {
        for (i = 0; i < n; i++)
        {
            printf("0\n");
        }
    }
    else if (1 == zeroCnt)
    {
        for (i = 0; i < n; i++)
        {
            if (zeroMark == i)
            {
                printf("%lld\n", result);
            }
            else
            {
                printf("0\n");
            }
        }
    }
    else
    {
        for (i = 0; i < n; i++)
        {
            printf("%lld\n", result / A[i]);
        }
    }
}

int main(int argc, char **argv)
{
    int i = 0;
    int N = 0;
    scanf("%d", &N);
    int* A = (int*) malloc(sizeof(int) * N);
    for (i = 0; i < N; i++)
    {
        scanf("%d", A + i);
    }
    multiply(A, N);
    free(A);
    return 0;
}

