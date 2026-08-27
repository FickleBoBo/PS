#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n, int k) {
    vector<int> v;
    for (int i = k; i <= n; i += k) {
        v.push_back(i);
    }

    return v;
}
