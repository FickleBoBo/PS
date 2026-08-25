#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> emergency) {
    int n = emergency.size();

    vector<int> idx(n);
    for (int i = 0; i < n; i++) idx[i] = i;

    sort(idx.begin(), idx.end(), [&](int a, int b) {
        return emergency[a] > emergency[b];
    });

    vector<int> ans(n);
    for (int i = 0; i < n; i++) {
        ans[idx[i]] = i + 1;
    }

    return ans;
}
