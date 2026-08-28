#include <bits/stdc++.h>
using namespace std;

int func(vector<int>& money, int start, int end) {
    int prv2 = 0, prv1 = 0;

    for (int i = start; i < end; i++) {
        int cur = max(prv1, prv2 + money[i]);
        prv2 = prv1;
        prv1 = cur;
    }

    return prv1;
}

int solution(vector<int> money) {
    int n = money.size();

    int case1 = func(money, 0, n - 1);
    int case2 = func(money, 1, n);
    return max(case1, case2);
}
