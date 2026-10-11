#include <bits/stdc++.h>
using namespace std;

string solution(string s) {
    int len = s.size();
    return s.substr((len - 1) / 2, 2 - len % 2);
}
