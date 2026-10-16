#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        long long n, m, l, r, u, d;
        cin >> n >> m >> l >> r >> u >> d;

        long long ht = (u + d != 0) ? (n - 1 + u + d - 1) / (u + d) : 0;
        long long wt = (l + r != 0) ? (m - 1 + l + r - 1) / (l + r) : 0;

        long long cnt = 1;
        if (ht != 0) cnt *= n;
        if (wt != 0) cnt *= m;

        cout << cnt << ' ' << ht + wt << '\n';
    }
}
