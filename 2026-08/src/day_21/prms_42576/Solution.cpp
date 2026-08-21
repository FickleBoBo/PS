#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> mp;

    for (string& p : participant) mp[p]++;
    for (string& c : completion) mp[c]--;

    for (auto& [k, v] : mp) {
        if (v == 1) return k;
    }

    return "";
}
