#include <bits/stdc++.h>
using namespace std;

const int MOD = 10007;
int dp[1 + 1000][1 + 1000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    for (int i = 0; i <= n; i++) {
        dp[i][0] = 1;

        for (int j = 1; j <= min(i, k); j++) {
            dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
        }
    }

    cout << dp[n][k];
}
