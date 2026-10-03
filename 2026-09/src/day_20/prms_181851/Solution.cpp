#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> rank, vector<bool> attendance) {
    vector<pair<int, int>> v;
    for (int i = 0; i < rank.size(); i++) {
        if (attendance[i]) v.emplace_back(rank[i], i);
    }
    sort(v.begin(), v.end());

    return 10'000 * v[0].second + 100 * v[1].second + v[2].second;
}
