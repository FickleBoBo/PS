#include <bits/stdc++.h>
using namespace std;

string solution(string myString) {
    string s;
    for (char c : myString) {
        if (c == 'a') {
            s += 'A';
        } else if ('B' <= c && c <= 'Z') {
            s += tolower(c);
        } else {
            s += c;
        }
    }

    return s;
}
