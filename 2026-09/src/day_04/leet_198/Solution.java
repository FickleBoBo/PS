package day_04.leet_198;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[1 + n];

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[Math.max(i - 2, 0)] + nums[i - 1]);
        }

        return dp[n];
    }
}
