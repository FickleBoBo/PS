#include <bits/stdc++.h>
using namespace std;

bool func(int x) {
    while (x > 0) {
        int r = x % 10;
        if (r != 0 && r != 5) return false;
        x /= 10;
    }

    return true;
}

vector<int> solution(int l, int r) {
    vector<int> v;
    for (int i = l; i <= r; i++) {
        if (func(i)) v.push_back(i);
    }

    if (v.empty()) return {-1};
    return v;
}
