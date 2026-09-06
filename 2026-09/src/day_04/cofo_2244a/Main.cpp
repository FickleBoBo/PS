#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    string s;
    cin >> n >> s;

    int mx = 0, cnt = 0;
    for (char c : s) {
        if (c == '#') {
            cnt++;
        } else {
            cnt = 0;
        }

        mx = max(mx, (cnt + 1) / 2);
    }

    cout << mx << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
