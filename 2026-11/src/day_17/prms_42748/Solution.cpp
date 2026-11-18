#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> ans;
    for (auto& c : commands) {
        int i = c[0], j = c[1], k = c[2];
        vector<int> tmp(array.begin() + i - 1, array.begin() + j);
        sort(tmp.begin(), tmp.end());
        ans.push_back(tmp[k - 1]);
    }

    return ans;
}
