#include <bits/stdc++.h>
using namespace std;

bool check(int x) {
    while (x > 0) {
        int d = x % 10;
        if (d != 0 && d != 5) return false;
        x /= 10;
    }

    return true;
}

vector<int> solution(int l, int r) {
    vector<int> v;
    for (int i = l; i <= r; i++) {
        if (check(i)) v.push_back(i);
    }

    if (v.empty()) return {-1};
    return v;
}
