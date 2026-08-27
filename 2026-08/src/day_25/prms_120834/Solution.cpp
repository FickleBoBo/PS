#include <bits/stdc++.h>
using namespace std;

string solution(int age) {
    string s;
    while (age) {
        s += (char)(age % 10 + 'a');
        age /= 10;
    }
    reverse(s.begin(), s.end());

    return s;
}
