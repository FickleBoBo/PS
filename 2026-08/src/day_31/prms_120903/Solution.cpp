#include <bits/stdc++.h>
using namespace std;

int solution(vector<string> s1, vector<string> s2) {
    unordered_set<string> seen(s1.begin(), s1.end());
    int cnt = 0;

    for (string& s : s2) {
        if (seen.contains(s)) cnt++;
    }

    return cnt;
}
