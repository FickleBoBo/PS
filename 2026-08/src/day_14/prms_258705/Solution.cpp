#include <bits/stdc++.h>
using namespace std;

const int MOD = 10007;
int dp[1 + 100000][2];

int solution(int n, vector<int> tops) {
    dp[0][0] = 1;
    for (int i = 0; i < n; i++) {
        if (tops[i] == 0) {
            dp[i + 1][0] = (2 * dp[i][0] + dp[i][1]) % MOD;
        } else {
            dp[i + 1][0] = (3 * dp[i][0] + 2 * dp[i][1]) % MOD;
        }

        dp[i + 1][1] = (dp[i][0] + dp[i][1]) % MOD;
    }

    return (dp[n][0] + dp[n][1]) % MOD;
}
