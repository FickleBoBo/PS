#include <bits/stdc++.h>
using namespace std;

class Solution {
   public:
    int rob_range(vector<int>& nums, int l, int r) {
        int n = nums.size();
        vector<int> dp(1 + n);

        for (int i = l; i <= r; i++) {
            dp[i] = max(dp[i - 1], dp[max(i - 2, 0)] + nums[i - 1]);
        }

        return dp[r];
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return nums[0];

        int case1 = rob_range(nums, 1, n - 1);
        int case2 = rob_range(nums, 2, n);
        return max(case1, case2);
    }
};
