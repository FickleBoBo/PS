#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, k;
    cin >> n >> k;

    if (k < n || 2 * n - 1 < k) {
        cout << -1 << '\n';
        return;
    }

    vector<vector<int>> a(n, vector<int>(n));
    int num = 1;
    int m = 2 * n - k;

    for (int i = 0; i < m; i++) {
        a[i][i] = num++;
    }
    for (int i = m; i < n; i++) {
        a[m - 1][i] = num++;
    }
    for (int i = m; i < n; i++) {
        a[i][n - 1] = num++;
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (a[i][j] != 0) {
                cout << a[i][j] << ' ';
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
