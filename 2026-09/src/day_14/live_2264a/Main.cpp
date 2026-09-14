#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> p(n);
    for (int& x : p) cin >> x;

    vector<bool> seen(n);
    for (int i = 0; i < n; i++) {
        if (p[i] == i + 1) seen[i] = true;
    }

    bool ok = true;
    int prv = n + 1;
    for (int i = 0; i < n; i++) {
        if (!seen[i]) {
            if (prv > p[i]) {
                prv = p[i];
            } else {
                ok = false;
            }
        }
    }

    cout << (ok ? "YES\n" : "NO\n");
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
