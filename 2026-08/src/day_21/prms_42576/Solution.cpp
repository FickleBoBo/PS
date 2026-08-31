#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> cnt;
    for (string& p : participant) cnt[p]++;
    for (string& c : completion) cnt[c]--;

    for (auto& [k, v] : cnt) {
        if (v == 1) return k;
    }

    return "";
}
