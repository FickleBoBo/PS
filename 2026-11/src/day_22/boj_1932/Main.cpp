#include <bits/stdc++.h>
using namespace std;

const int MAX_N = 1 + 500;
int arr[MAX_N][MAX_N];
int dp[MAX_N][MAX_N];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
        }
    }

    int mx = 0;
    for (int i = 1; i <= n; i++) {
        mx = max(mx, dp[n][i]);
    }

    cout << mx;
}
