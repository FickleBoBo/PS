#include <bits/stdc++.h>
using namespace std;

void solve() {
    long long x, y, k;
    cin >> x >> y >> k;

    long long diff = y - x;
    long long sum = 0;

    long long i = 0;
    for (; i < k && x + i <= diff; i++) {
        sum += diff % (x + i);
    }
    sum += diff * (k - i);

    cout << sum << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
