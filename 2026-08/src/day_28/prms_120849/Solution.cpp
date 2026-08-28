#include <bits/stdc++.h>
using namespace std;

string solution(string my_string) {
    string s;
    for (char c : my_string) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
        s += c;
    }

    return s;
}
