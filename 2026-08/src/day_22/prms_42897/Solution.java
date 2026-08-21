package day_22.prms_42897;

class Solution {
    public int solution(int[] money) {
        int n = money.length;

        int case1 = func(money, 1, n - 1);
        int case2 = func(money, 2, n);
        return Math.max(case1, case2);
    }

    static int func(int[] money, int start, int end) {
        int n = money.length;
        int[] dp = new int[1 + n];

        for (int i = start; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[(i - 2 + n) % n] + money[i - 1]);
        }

        return dp[end];
    }
}
