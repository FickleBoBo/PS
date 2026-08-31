#include <bits/stdc++.h>
using namespace std;

vector<string> solution(vector<string> quiz) {
    vector<string> ans;

    for (string& q : quiz) {
        stringstream ss(q);
        int x, y, z;
        char op, eq;
        ss >> x >> op >> y >> eq >> z;

        int res = op == '+' ? x + y : x - y;
        ans.push_back(res == z ? "O" : "X");
    }

    return ans;
}
