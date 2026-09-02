#include <bits/stdc++.h>
using namespace std;

string solution(string my_string) {
    string s;
    unordered_set<char> seen;

    for (char c : my_string) {
        if (seen.insert(c).second) s += c;
    }

    return s;
}
