#include <bits/stdc++.h>
using namespace std;

int cnt[26];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s1, s2;
    cin >> s1 >> s2;

    for (char c : s1) cnt[c - 'a']++;
    for (char c : s2) cnt[c - 'a']--;

    int ans = 0;
    for (int x : cnt) {
        ans += abs(x);
    }

    cout << ans;
}
