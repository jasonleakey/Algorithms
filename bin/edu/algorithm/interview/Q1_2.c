/*
 * =====================================================================================
 *
 *       Filename:  Q1_2.c
 *
 *        Created:  12/15/2012 11:29:43 PM
 *
 *        Author: Jason Huang
 *
 * =====================================================================================
 */

#include <stdio.h>
#include <stdlib.h>

void reverse(char* str)
{
    char* p = str;
    char* q = str;

    while ('\0' != *(q + 1))
    {
        q++;
    }

    while (p < q)
    {
        char temp = *p;
        *p = *q;
        *q = temp;

        p++;
        q--;
    }
}

//int main(int argc, char **argv)
//{
//    char str[] = "bingo";
//    reverse(str);
//
//    printf("%s\n", str);
//    return 0;
//}

