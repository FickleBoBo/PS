#include <bits/stdc++.h>
using namespace std;

const int MOD = 1'000'000'000;
int dp[1 + 100][10];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int j = 1; j <= 9; j++) {
        dp[1][j] = 1;
    }

    for (int i = 2; i <= n; i++) {
        dp[i][0] = dp[i - 1][1];
        for (int j = 1; j <= 8; j++) {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
        }
        dp[i][9] = dp[i - 1][8];
    }

    long long sum = 0;
    for (int j = 0; j <= 9; j++) {
        sum += dp[n][j];
    }

    cout << sum % MOD;
}
