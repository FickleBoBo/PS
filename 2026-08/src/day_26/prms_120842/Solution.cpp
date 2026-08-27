#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> solution(vector<int> num_list, int n) {
    vector<vector<int>> v(num_list.size() / n, vector<int>(n));
    for (int i = 0; i < num_list.size() / n; i++) {
        copy(num_list.begin() + i * n, num_list.begin() + (i + 1) * n, v[i].begin());
    }

    return v;
}
