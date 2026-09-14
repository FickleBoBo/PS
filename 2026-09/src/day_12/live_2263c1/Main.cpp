#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<bool> chk(n + 1, true);
    chk[n] = false;
    chk[v[0]] = false;

    for (int i = 1; i < n; i++) {
        int s = (i + 1) * v[i];
        int e = (i + 1) * (v[i] + 1);

        for (int j = min(s, n); j < min(e, n); j++) {
            chk[j] = false;
        }
    }

    int cnt = count(chk.begin(), chk.end(), true);
    cout << cnt << '\n';
    if (cnt) {
        for (int i = 0; i < n; i++) {
            if (chk[i]) cout << i << ' ';
        }
        cout << '\n';
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
