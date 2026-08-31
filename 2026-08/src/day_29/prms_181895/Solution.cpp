#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> intervals) {
    vector<int> v;
    for (auto& interval : intervals) {
        for (int i = interval[0]; i <= interval[1]; i++) {
            v.push_back(arr[i]);
        }
    }

    return v;
}
