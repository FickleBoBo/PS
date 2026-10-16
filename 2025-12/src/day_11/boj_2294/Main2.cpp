#include <bits/stdc++.h>
using namespace std;

const int INF = 10001;
int dp[1 + 10000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for (int& x : coins) cin >> x;

    fill(dp + 1, dp + 10001, INF);  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 사용한 동전은 0개
    for (int coin : coins) {
        for (int j = coin; j <= k; j++) {
            dp[j] = min(dp[j - coin] + 1, dp[j]);
        }
    }

    if (dp[k] == INF) {
        cout << -1;
    } else {
        cout << dp[k];
    }
}
