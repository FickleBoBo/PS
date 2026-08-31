#include <bits/stdc++.h>
using namespace std;

int solve(vector<int>& money, int l, int r) {
    int n = money.size();
    vector<int> dp(1 + n);

    for (int i = l; i <= r; i++) {
        dp[i] = max(dp[i - 1], dp[max(i - 2, 0)] + money[i - 1]);
    }

    return dp[r];
}

int solution(vector<int> money) {
    int n = money.size();

    int case1 = solve(money, 1, n - 1);
    int case2 = solve(money, 2, n);
    return max(case1, case2);
}
