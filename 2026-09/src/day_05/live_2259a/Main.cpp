#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, k;
    string s;
    cin >> n >> k >> s;

    int cnt = 0;
    for (int i = 0; i < n; i += k) {
        bool flag = false;
        for (int j = i; j < i + k; j++) {
            if (s[j] == '0') flag = true;
        }

        if (!flag) cnt++;
    }

    cout << cnt << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
