#include <bits/stdc++.h>
using namespace std;

int solve(vector<int>& money, int l, int r) {
    int prv2 = 0, prv1 = 0;

    for (int i = l; i < r; i++) {
        int cur = max(prv1, prv2 + money[i]);
        prv2 = prv1;
        prv1 = cur;
    }

    return prv1;
}

int solution(vector<int> money) {
    int n = money.size();

    int case1 = solve(money, 0, n - 1);
    int case2 = solve(money, 1, n);
    return max(case1, case2);
}
