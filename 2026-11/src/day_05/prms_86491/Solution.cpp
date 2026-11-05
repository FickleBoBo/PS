#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int>> sizes) {
    for (auto& x : sizes) {
        if (x[0] < x[1]) swap(x[0], x[1]);
    }

    int w = 0, h = 0;
    for (auto& x : sizes) {
        w = max(w, x[0]);
        h = max(h, x[1]);
    }

    return w * h;
}
