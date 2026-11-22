#include <bits/stdc++.h>
using namespace std;

const int MOD = 15746;
int dp[1 + 1'000'000] = {0, 1, 2};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
    }

    cout << dp[n];
}
