#include <bits/stdc++.h>
using namespace std;

string solution(string code) {
    string ret;
    int mode = 0;

    for (int i = 0; i < code.size(); i++) {
        char c = code[i];
        if (c == '1') {
            mode = 1 - mode;
            continue;
        }

        if (i % 2 == mode) ret += c;
    }

    if (ret.empty()) return "EMPTY";
    return ret;
}
