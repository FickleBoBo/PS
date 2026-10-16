#include <bits/stdc++.h>
using namespace std;

const int INF = 100000;
int dp[1 + 20][1 + 1100];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int c, n;
    cin >> c >> n;

    vector<pair<int, int>> a(n);
    for (auto& [cost, person] : a) cin >> cost >> person;

    fill(dp[0] + 1, dp[0] + 1101, INF);
    for (int i = 1; i <= n; i++) {
        auto [cost, person] = a[i - 1];

        for (int j = 1; j <= c + 100; j++) {
            if (j < person) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = min(dp[i][j - person] + cost, dp[i - 1][j]);
            }
        }
    }

    int mn = INF;
    for (int j = c; j <= c + 100; j++) {
        mn = min(mn, dp[n][j]);
    }

    cout << mn;
}
