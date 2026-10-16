#include <bits/stdc++.h>
using namespace std;

bool dp[1 + 1000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    dp[2] = dp[4] = true;
    for (int i = 5; i <= n; i++) {
        if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) {
            dp[i] = true;
        }
    }

    if (dp[n]) {
        cout << "SK";
    } else {
        cout << "CY";
    }
}
