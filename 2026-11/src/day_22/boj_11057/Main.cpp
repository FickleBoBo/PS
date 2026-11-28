#include <bits/stdc++.h>
using namespace std;

const int MOD = 10007;
int dp[1 + 1000][10];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int j = 0; j <= 9; j++) {
        dp[1][j] = 1;
    }

    for (int i = 2; i <= n; i++) {
        for (int j = 0; j <= 9; j++) {
            for (int k = j; k <= 9; k++) {
                dp[i][j] += dp[i - 1][k];
            }
            dp[i][j] %= MOD;
        }
    }

    int sum = 0;
    for (int j = 0; j <= 9; j++) {
        sum += dp[n][j];
    }

    cout << sum % MOD;
}
