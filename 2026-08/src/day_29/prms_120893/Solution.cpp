#include <bits/stdc++.h>
using namespace std;

string solution(string my_string) {
    string s;
    for (char c : my_string) {
        if (islower(c)) {
            s += toupper(c);
        } else {
            s += tolower(c);
        }
    }

    return s;
}
