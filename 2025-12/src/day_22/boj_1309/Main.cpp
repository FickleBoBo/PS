#include <bits/stdc++.h>
using namespace std;

const int MOD = 9901;
int dp[1 + 100000][2];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        dp[i][1] = (2 * dp[i - 1][0] + dp[i - 1][1]) % MOD;
    }

    cout << (dp[n][0] + dp[n][1]) % MOD;
}
