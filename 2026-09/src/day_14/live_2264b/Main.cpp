#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, m;
    cin >> n >> m;

    vector<int> a(n);
    for (int& x : a) cin >> x;

    vector<int> diff(n);
    for (int i = 1; i < n; i++) {
        diff[i] = a[i] - a[i - 1];
    }
    vector<bool> chk(n, true);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
