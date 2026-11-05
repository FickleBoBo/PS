#include <bits/stdc++.h>
using namespace std;

string solution(int n) {
    string s;
    for (int i = 0; i < n / 2; i++) {
        s += "수박";
    }
    if (n % 2) s += "수";

    return s;
}
