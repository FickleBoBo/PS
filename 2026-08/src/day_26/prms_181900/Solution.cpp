#include <bits/stdc++.h>
using namespace std;

string solution(string my_string, vector<int> indices) {
    for (int i : indices) {
        my_string[i] = '\0';
    }

    string s;
    for (char c : my_string) {
        if (c != '\0') s += c;
    }

    return s;
}
