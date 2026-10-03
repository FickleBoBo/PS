#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> numlist, int n) {
    sort(numlist.begin(), numlist.end(), [&](auto& a, auto& b) {
        int da = abs(n - a), db = abs(n - b);
        if (da != db) return da < db;
        return a > b;
    });

    return numlist;
}
