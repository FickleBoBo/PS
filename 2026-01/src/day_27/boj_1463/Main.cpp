#include <bits/stdc++.h>
using namespace std;

const int INF = 100000;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> dp(1 + n * 3, INF);
    dp[1] = 0;

    for (int i = 1; i <= n; i++) {
        dp[i * 3] = min(dp[i * 3], dp[i] + 1);
        dp[i * 2] = min(dp[i * 2], dp[i] + 1);
        dp[i + 1] = min(dp[i + 1], dp[i] + 1);
    }

    cout << dp[n];
}
