#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, int> cnt;
    for (auto& c : clothes) cnt[c[1]]++;

    int ans = 1;
    for (auto& [_, v] : cnt) {
        ans *= v + 1;
    }

    return ans - 1;
}
