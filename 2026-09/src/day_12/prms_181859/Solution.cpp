#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> stk;

    for (int x : arr) {
        if (stk.empty() || stk.back() != x) {
            stk.push_back(x);
        } else {
            stk.pop_back();
        }
    }

    if (stk.empty()) return {-1};
    return stk;
}
