package day_04.leet_213;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int case1 = solve(nums, 1, n - 1);
        int case2 = solve(nums, 2, n);
        return Math.max(case1, case2);
    }

    static int solve(int[] nums, int l, int r) {
        int n = nums.length;
        int[] dp = new int[1 + n];

        for (int i = l; i <= r; i++) {
            dp[i] = Math.max(dp[i - 1], dp[Math.max(i - 2, 0)] + nums[i - 1]);
        }

        return dp[r];
    }
}
