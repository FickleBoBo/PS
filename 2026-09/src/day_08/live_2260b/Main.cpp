#include <bits/stdc++.h>
using namespace std;

void solve() {
    long long x, y, k;
    cin >> x >> y >> k;

    long long sum = 0;
    if (y - 2 * x < 0) {
        sum += (y - x) * k;
    } else {
        if (y - 2 * x >= k) {
            for (int i = 0; i < k; i++) {
                sum += (y + i) % (x + i);
            }
        } else {
            for (int i = 0; i < y - 2 * x; i++) {
                sum += (y + i) % (x + i);
            }
            sum += (y - x) * (k - y + 2 * x - 1);
        }
    }

    cout << sum << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
