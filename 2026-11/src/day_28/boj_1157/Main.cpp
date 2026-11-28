#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    vector<int> cnt(26);
    for (char c : s) {
        cnt[tolower(c) - 'a']++;
    }

    int mx = *max_element(cnt.begin(), cnt.end());

    if (count(cnt.begin(), cnt.end(), mx) > 1) {
        cout << '?';
    } else {
        int idx = max_element(cnt.begin(), cnt.end()) - cnt.begin();
        cout << char(idx + 'A');
    }
}
