#include <bits/stdc++.h>
using namespace std;

string solution(int q, int r, string code) {
    string s;
    for (int i = r; i < code.size(); i += q) {
        s += code[i];
    }

    return s;
}
