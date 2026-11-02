#include <bits/stdc++.h>
using namespace std;

string solution(string s, int n) {
    for (char& c : s) {
        if ('A' <= c && c <= 'Z') {
            c = (c - 'A' + n) % 26 + 'A';
        } else if ('a' <= c && c <= 'z') {
            c = (c - 'a' + n) % 26 + 'a';
        }
    }

    return s;
}
