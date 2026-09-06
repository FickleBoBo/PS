#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> b(n);
    for (int& x : b) cin >> x;

    vector<int> diff(n + 1);
    for (int i = 0; i < n; i++) {
        if (b[i] > 0) {
            diff[max(i - b[i] + 1, 0)]++;
            diff[min(i + b[i], n)]--;
        }
    }
    for (int i = 1; i <= n; i++) {
        diff[i] += diff[i - 1];
    }

    string ans(n, '0');
    for (int i = 0; i < n; i++) {
        if (diff[i] == 0) ans[i] = '1';
    }

    for (int i = 0; i < n; i++) {
        if (b[i] == 0 && ans[i] == '0') {
            cout << -1 << '\n';
            return;
        }
    }

    for (int i = 0; i < n; i++) {
        if (b[i] <= 0) continue;
        int l = i - b[i], r = i + b[i];
        if (!((l >= 0 && ans[l] == '1') || (r < n && ans[r] == '1'))) {
            cout << -1 << '\n';
            return;
        }
    }

    cout << ans << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
