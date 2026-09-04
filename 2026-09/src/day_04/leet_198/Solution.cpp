#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(1 + n);

        for (int i = 1; i <= n; i++) {
            dp[i] = max(dp[i - 1], dp[max(i - 2, 0)] + nums[i - 1]);
        }

        return dp[n];
    }
};
