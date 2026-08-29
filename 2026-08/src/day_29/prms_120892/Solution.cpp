#include <bits/stdc++.h>
using namespace std;

string solution(string cipher, int code) {
    string s;
    for (int i = code - 1; i < cipher.size(); i += code) {
        s += cipher[i];
    }

    return s;
}
