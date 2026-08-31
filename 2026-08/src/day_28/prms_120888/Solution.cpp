#include <bits/stdc++.h>
using namespace std;

string solution(string my_string) {
    string s;
    set<char> seen;

    for (char c : my_string) {
        if (seen.contains(c)) continue;
        s += c;
        seen.insert(c);
    }

    return s;
}
