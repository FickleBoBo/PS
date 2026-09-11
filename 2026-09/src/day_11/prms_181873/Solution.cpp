#include <bits/stdc++.h>
using namespace std;

string solution(string my_string, string alp) {
    char c = alp[0];
    for (char& x : my_string) {
        if (x == c) x = toupper(x);
    }

    return my_string;
}
