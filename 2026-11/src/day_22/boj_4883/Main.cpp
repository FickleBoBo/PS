#include <bits/stdc++.h>
using namespace std;

const int INF = 1'000'000'000;
const int MAX_N = 100000;
int arr[MAX_N][3];
int dp[MAX_N][3];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int tc = 1;; tc++) {
        int n;
        cin >> n;
        if (n == 0) break;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cin >> arr[i][j];
            }
        }

        dp[0][0] = INF;
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][1] + arr[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
            dp[i][1] = min({dp[i][0], dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]}) + arr[i][1];
            dp[i][2] = min({dp[i][1], dp[i - 1][1], dp[i - 1][2]}) + arr[i][2];
        }

        cout << tc << ". " << dp[n - 1][1] << '\n';
    }
}
