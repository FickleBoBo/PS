#include <bits/stdc++.h>
using namespace std;

const int MAXN = 100;
const int MOD = 1'000'000'007;
bool chk[1 + MAXN][1 + MAXN];
int dp[1 + MAXN][1 + MAXN];

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
