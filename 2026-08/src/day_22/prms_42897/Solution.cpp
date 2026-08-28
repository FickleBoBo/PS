#include <bits/stdc++.h>
using namespace std;

int func(vector<int>& money, int start, int end) {
    int n = money.size();
    vector<int> dp(1 + n);

    for (int i = start; i <= end; i++) {
        dp[i] = max(dp[i - 1], dp[max(i - 2, 0)] + money[i - 1]);
    }

    return dp[end];
}

int solution(vector<int> money) {
    int n = money.size();

    int case1 = func(money, 1, n - 1);
    int case2 = func(money, 2, n);
    return max(case1, case2);
}
