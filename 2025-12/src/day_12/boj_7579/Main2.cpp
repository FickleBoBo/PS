#include <bits/stdc++.h>
using namespace std;

int dp[1 + 10000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    vector<int> ma(n);
    for (int& x : ma) cin >> x;

    vector<int> ca(n);
    for (int& x : ca) cin >> x;

    int sum = 0;
    for (int x : ca) sum += x;

    for (int i = 0; i < n; i++) {
        int mi = ma[i];
        int ci = ca[i];

        for (int j = sum; j >= ci; j--) {
            dp[j] = max(dp[j - ci] + mi, dp[j]);
        }
    }

    for (int j = 0; j <= sum; j++) {
        if (dp[j] >= m) {
            cout << j;
            return 0;
        }
    }
}
