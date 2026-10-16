#include <bits/stdc++.h>
using namespace std;

int dp[2][1 + 10000];  // 롤링 배열

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for (int& x : coins) cin >> x;

    int prv = 0;
    int cur = 1;
    dp[0][0] = 1;  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 1가지
    for (int coin : coins) {
        for (int j = 0; j <= k; j++) {
            if (j < coin) {
                dp[cur][j] = dp[prv][j];
            } else {
                dp[cur][j] = dp[prv][j] + dp[cur][j - coin];
            }
        }

        // 롤링
        prv ^= 1;
        cur ^= 1;
    }

    cout << dp[prv][k];
}
