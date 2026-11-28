#include <bits/stdc++.h>
using namespace std;

int dp[1 + 40] = {0, 1, 1};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 3; i <= 40; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    cout << dp[n] << ' ' << n - 2;
}
