#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int>> arr(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        arr[i][i] = 1;
    }

    return arr;
}
