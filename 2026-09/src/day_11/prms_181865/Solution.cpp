#include <bits/stdc++.h>
using namespace std;

int solution(string binomial) {
    stringstream ss(binomial);
    int a, b;
    string op;
    ss >> a >> op >> b;

    if (op == "+") return a + b;
    if (op == "-") return a - b;
    return a * b;
}
