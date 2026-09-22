#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr) {
    int len = max(arr.size(), arr[0].size());
    vector<vector<int>> res(len, vector<int>(len));
    for (int i = 0; i < arr.size(); i++) {
        copy(arr[i].begin(), arr[i].end(), res[i].begin());
    }

    return res;
}
