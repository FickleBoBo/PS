#include <bits/stdc++.h>
using namespace std;

const int INF = 10001;
int dp[1 + 100][1 + 10000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for (int& x : coins) cin >> x;

    fill(dp[0] + 1, dp[0] + 10001, INF);  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 사용한 동전은 0개
    for (int i = 1; i <= n; i++) {
        int coin = coins[i - 1];

        for (int j = 1; j <= k; j++) {
            if (j < coin) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = min(dp[i][j - coin] + 1, dp[i - 1][j]);
            }
        }
    }

    if (dp[n][k] == INF) {
        cout << -1;
    } else {
        cout << dp[n][k];
    }
}
