#include <bits/stdc++.h>
using namespace std;

string solution(string rsp) {
    string s;
    for (char c : rsp) {
        if (c == '0') {
            s += '5';
        } else if (c == '2') {
            s += '0';
        } else {
            s += '2';
        }
    }

    return s;
}
