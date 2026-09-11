#include <bits/stdc++.h>
using namespace std;

string solution(string rny_string) {
    string s;
    for (char c : rny_string) {
        if (c == 'm') {
            s += "rn";
        } else {
            s += c;
        }
    }

    return s;
}
