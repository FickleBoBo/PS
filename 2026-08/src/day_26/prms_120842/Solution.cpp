#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> solution(vector<int> num_list, int n) {
    vector<vector<int>> v;
    for (int i = 0; i < num_list.size(); i += n) {
        v.emplace_back(num_list.begin() + i, num_list.begin() + i + n);
    }

    return v;
}
