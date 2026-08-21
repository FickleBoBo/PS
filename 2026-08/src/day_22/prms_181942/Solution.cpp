#include <bits/stdc++.h>
using namespace std;

string solution(string str1, string str2) {
    string s;
    int idx = 0;

    while (idx < str1.size()) {
        s += str1[idx];
        s += str2[idx];
        idx++;
    }

    return s;
}
