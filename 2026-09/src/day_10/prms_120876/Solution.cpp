#include <bits/stdc++.h>
using namespace std;

int cnt[100 + 1 + 100];

int solution(vector<vector<int>> lines) {
    for (auto& line : lines) {
        for (int i = line[0]; i < line[1]; i++) {
            cnt[i + 100]++;
        }
    }

    int ans = 0;
    for (int x : cnt) {
        if (x >= 2) ans++;
    }

    return ans;
}
