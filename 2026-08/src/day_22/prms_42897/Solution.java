package day_22.prms_42897;

class Solution {
    public int solution(int[] money) {
        int n = money.length;

        int case1 = solve(money, 1, n - 1);
        int case2 = solve(money, 2, n);
        return Math.max(case1, case2);
    }

    static int solve(int[] money, int l, int r) {
        int n = money.length;
        int[] dp = new int[1 + n];

        for (int i = l; i <= r; i++) {
            dp[i] = Math.max(dp[i - 1], dp[Math.max(i - 2, 0)] + money[i - 1]);
        }

        return dp[r];
    }
}
