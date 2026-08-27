#include <bits/stdc++.h>
using namespace std;

string solution(string my_string, int m, int c) {
    string s;
    for (int i = c - 1; i < my_string.size(); i += m) {
        s += my_string[i];
    }

    return s;
}
