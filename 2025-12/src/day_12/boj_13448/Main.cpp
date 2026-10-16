#include <bits/stdc++.h>
using namespace std;

long long dp[1 + 50][1 + 100000];

struct Item {
    int m;
    long long p;  // 점수 계산에서 오버플로우 방지
    int r;
};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, t;
    cin >> n >> t;

    vector<Item> items(n);
    for (int i = 0; i < n; i++) cin >> items[i].m;
    for (int i = 0; i < n; i++) cin >> items[i].p;
    for (int i = 0; i < n; i++) cin >> items[i].r;
    sort(items.begin(), items.end(), [](auto& a, auto& b) {
        return a.r * b.p < a.p * b.r;
    });

    for (int i = 1; i <= n; i++) {
        auto [m, p, r] = items[i - 1];

        for (int j = 1; j <= t; j++) {
            if (j < r) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = max(dp[i - 1][j - r] + (m - j * p), dp[i - 1][j]);
            }
        }
    }

    long long mx = 0;
    for (int j = 1; j <= t; j++) {
        mx = max(mx, dp[n][j]);
    }

    cout << mx;
}
