#include <bits/stdc++.h>
using namespace std;

string solution(string my_string, int n) {
    string s;
    for (char c : my_string) {
        s.append(n, c);
    }

    return s;
}
