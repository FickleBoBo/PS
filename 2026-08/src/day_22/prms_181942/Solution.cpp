#include <bits/stdc++.h>
using namespace std;

string solution(string str1, string str2) {
    string s;
    for (int i = 0; i < str1.size(); i++) {
        s += str1[i];
        s += str2[i];
    }

    return s;
}
