#include <bits/stdc++.h>
using namespace std;

int dp[1 + 40][2];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    dp[0][0] = dp[1][1] = 1;
    for (int i = 2; i <= 40; i++) {
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
    }

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;
        cout << dp[n][0] << ' ' << dp[n][1] << '\n';
    }
}
