package day_10.PRMS_12900;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int solution(int n) {
        if (n <= 2) return n;

        int[] dp = new int[1 + n];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }
}
