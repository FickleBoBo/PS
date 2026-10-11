#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int& x : a) cin >> x;

    int m = n - 4;
    vector<int> b(m);
    for (int i = 0; i < m; i++) b[i] = a[i] + a[i + 2] - a[i + 4];

    unordered_map<int, long long> cnt;
    for (int x : b) cnt[x]++;

    long long ans = 0;
    for (auto [_, v] : cnt) ans += v * (v - 1) / 2;
    for (int i = 0; i + 2 < m; i++) ans -= b[i] == b[i + 2];
    for (int i = 0; i + 4 < m; i++) ans -= b[i] == b[i + 4];

    cout << ans << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
