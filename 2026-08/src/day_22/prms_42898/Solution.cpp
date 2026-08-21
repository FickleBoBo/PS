#include <bits/stdc++.h>
using namespace std;

int MOD = 1'000'000'007;
bool chk[1 + 100][1 + 100];
int dp[1 + 100][1 + 100];

int solution(int m, int n, vector<vector<int>> puddles) {
    for (auto& p : puddles) {
        chk[p[1]][p[0]] = true;
    }

    dp[0][1] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (chk[i][j]) continue;
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
        }
    }

    return dp[n][m];
}
