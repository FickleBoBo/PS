#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, m;
    cin >> n >> m;

    vector<bool> seen(26);
    while (n--) {
        string s;
        cin >> s;
        seen[s[0] - 'a'] = true;
    }

    bool flag = true;
    while (m--) {
        string s;
        cin >> s;

        for (char c : s) {
            if (!seen[c - 'A']) flag = false;
        }
    }

    cout << (flag ? "YES" : "NO") << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
