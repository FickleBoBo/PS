#include <bits/stdc++.h>
using namespace std;

void solve() {
    int x, y;
    cin >> x >> y;

    int sum = x + y;
    int res = 0;
    for (int b = 29; b >= 0; b--) {
        if ((sum & (1 << b)) && (res | (1 << b)) <= x) {
            res |= 1 << b;
        }
    }

    cout << sum << ' ' << x - res << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
