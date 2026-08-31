#include <bits/stdc++.h>
using namespace std;

int solution(string my_string) {
    stringstream ss(my_string);
    int ans, x;
    char op;

    ss >> ans;
    while (ss >> op >> x) {
        ans += op == '+' ? x : -x;
    }

    return ans;
}
