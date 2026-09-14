#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, k;
    cin >> n >> k;

    if (k < n || 2 * n - 1 < k) {
        cout << -1 << '\n';
        return;
    }

    vector<vector<int>> v(n, vector<int>(n));
    int num = 1;
    int p = 2 * n - k - 1;

    for (int i = 0; i <= p; i++) {
        v[i][i] = num++;
    }
    for (int i = p + 1; i < n; i++) {
        v[p][i] = num++;
    }
    for (int i = p + 1; i < n; i++) {
        v[i][n - 1] = num++;
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (v[i][j] != 0) {
                cout << v[i][j] << ' ';
            } else {
                cout << num++ << ' ';
            }
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
