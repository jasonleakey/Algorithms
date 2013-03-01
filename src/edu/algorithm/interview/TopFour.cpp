/*
 * TopFour.cc
 *
 *  Created on: Feb 3, 2013
 *      Author: jasonleakey
 */

#include <iostream>
#include <climits>

using namespace std;

void topFour(int A[], int n)
{
    int max1 = INT_MIN;
    int max2 = INT_MIN;
    int max3 = INT_MIN;
    int max4 = INT_MIN;

    for (int i = 0; i < n; i++)
    {
        if (A[i] >= max1)
        {
            max4 = max3;
            max3 = max2;
            max2 = max1;
            max1 = A[i];
        }

        else if (A[i] >= max2)
        {
            max4 = max3;
            max3 = max2;
            max2 = A[i];
        }

        else if (A[i] >= max3)
        {
            max4 = max3;
            max3 = A[i];
        }

        else if (A[i] >= max4)
        {
            max4 = A[i];
        }
    }

    if (n >= 1)
    {
        cout << max1 << endl;
    }
    if (n >= 2)
    {
        cout << max2 << endl;
    }
    if (n >= 3)
    {
        cout << max3 << endl;
    }
    if (n >= 4)
    {
        cout << max4 << endl;
    }
}

int main(int argc, char **argv)
{
    int n = 0;
    cin >> n;
    int *p = new int[n];
    for (int i = 0; i < n; i++)
    {
        cin >> p[i];
    }
    topFour(p, n);
    return 0;
}

