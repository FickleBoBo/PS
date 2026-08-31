#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    int n = arr.size();
    vector<int> diff(n + 1);

    for (auto& q : queries) {
        diff[q[0]]++;
        diff[q[1] + 1]--;
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += diff[i];
        arr[i] += sum;
    }

    return arr;
}
