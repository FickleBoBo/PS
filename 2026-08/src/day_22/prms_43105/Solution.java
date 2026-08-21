package day_22.prms_43105;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[1 + n][1 + n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j - 1];
            }
        }

        int max = 0;
        for (int x : dp[n]) {
            max = Math.max(max, x);
        }

        return max;
    }
}
