#include <bits/stdc++.h>
using namespace std;

bool seen[1 + 100000];

vector<int> solution(vector<int> arr, int k) {
    vector<int> ans(k, -1);

    int idx = 0;
    for (int x : arr) {
        if (seen[x]) continue;
        ans[idx++] = x;
        seen[x] = true;

        if (idx == k) break;
    }

    return ans;
}
