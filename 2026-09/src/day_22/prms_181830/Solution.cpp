#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr) {
    int n = max(arr.size(), arr[0].size());
    vector<vector<int>> ans(n, vector<int>(n));
    for (int i = 0; i < arr.size(); i++) {
        copy(arr[i].begin(), arr[i].end(), ans[i].begin());
    }

    return ans;
}
