#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int& x : a) cin >> x;

    unordered_map<int, long long> cnt;
    for (int i = 0; i < n - 4; i++) {
        cnt[a[i] + a[i + 2] - a[i + 4]]++;
    }

    long long ans = 0;
    for (auto [_, v] : cnt) {
        ans += v * (v - 1) / 2;
    }
    for (int i = 0; i < n - 6; i++) {
        if (a[i] + a[i + 2] - a[i + 4] == a[i + 2] + a[i + 4] - a[i + 6]) ans--;
    }
    for (int i = 0; i < n - 8; i++) {
        if (a[i] + a[i + 2] - a[i + 4] == a[i + 4] + a[i + 6] - a[i + 8]) ans--;
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
