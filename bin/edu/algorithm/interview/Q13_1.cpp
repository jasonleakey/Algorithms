/*
 * Q13_1.cpp
 *
 *  Created on: Jan 8, 2013
 *      Author: jasonleakey
 */

#include <iostream>
#include <vector>

using namespace std;

void printLines(string filename, int k)
{
    ifstream fin(filename);
    vector<string> s = new vector<string>();
    string line;
    while ((fin, line))
    {
        s.push_back(line);
    }
}

