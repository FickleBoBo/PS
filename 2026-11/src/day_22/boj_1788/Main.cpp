#include <bits/stdc++.h>
using namespace std;

const int MOD = 1'000'000'000;
int dp[1 + 1'000'000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    dp[1] = 1;
    if (n >= 0) {
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        cout << (dp[n] > 0) - (dp[n] < 0) << '\n';
        cout << dp[n];
    } else {
        n = abs(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] - dp[i - 1]) % MOD;
        }

        cout << (dp[n] > 0) - (dp[n] < 0) << '\n';
        cout << abs(dp[n]);
    }
}
