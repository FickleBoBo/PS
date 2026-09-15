#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int maxProfit(vector<int>& prices) {
        int mn = prices[0];
        int diff = 0;
        for (int i = 1; i < prices.size(); i++) {
            diff = max(diff, prices[i] - mn);
            mn = min(mn, prices[i]);
        }

        return diff;
    }
};
