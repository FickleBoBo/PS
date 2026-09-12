#include <bits/stdc++.h>
using namespace std;

void solve() {
    int x, y;
    cin >> x >> y;

    int sum = x + y;
    int k = 1 << 30;
    int cnt = 0;

    // while (k > 0 && (sum & k) == 0) k >>= 1;
    while (k > 0) {
        if (k & sum) {
            int tmp = (k & x) ^ (k & y);
            if (!tmp) {
                int diff = k - y;
                x -= diff;
                y += diff;
                cnt += diff;
            }
        }

        // cout << "k = " << k << '\n';
        k >>= 1;
    }

    cout << sum << ' ' << cnt << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
