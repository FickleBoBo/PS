#include <bits/stdc++.h>
using namespace std;

int solution(vector<string> strArr) {
    vector<int> cnt(1 + 30);
    for (string& s : strArr) cnt[s.size()]++;
    return *max_element(cnt.begin(), cnt.end());
}
