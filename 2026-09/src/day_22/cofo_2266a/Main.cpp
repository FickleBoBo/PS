#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, a1, a2, a3;
    cin >> n >> a1 >> a2 >> a3;
    cout << n - min({a1, a2, a3}) << '\n';
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t--) solve();
}
