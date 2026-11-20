#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1 + 100;
bool dp[MAX_N][MAX_N];

int solution(int n, vector<vector<int>> results) {
    for (auto& r : results) dp[r[0]][r[1]] = true;

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][k] && dp[k][j]) dp[i][j] = true;
            }
        }
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) {
        int cnt = 0;
        for (int j = 1; j <= n; j++) {
            if (dp[i][j] || dp[j][i]) cnt++;
        }

        if (cnt == n - 1) ans++;
    }

    return ans;
}
