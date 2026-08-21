#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int>> triangle) {
    int n = triangle.size();
    vector<vector<int>> dp(1 + n, vector<int>(1 + n));

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j - 1];
        }
    }

    return *max_element(dp[n].begin(), dp[n].end());
}
