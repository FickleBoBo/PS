#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, int> mp;
    for (auto& c : clothes) mp[c[1]]++;

    int ans = 1;
    for (auto& [_, v] : mp) {
        ans *= v + 1;
    }

    return ans - 1;
}
