#include <bits/stdc++.h>
using namespace std;

int dp[1 + 100][1 + 100000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    vector<pair<int, int>> a(n);
    for (auto& [w, v] : a) cin >> w >> v;

    for (int i = 1; i <= n; i++) {
        auto [w, v] = a[i - 1];

        for (int j = 1; j <= k; j++) {
            if (j < w) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = max(dp[i - 1][j - w] + v, dp[i - 1][j]);
            }
        }
    }

    cout << dp[n][k];
}
