package day_22.prms_42898;

class Solution {

    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        boolean[][] chk = new boolean[1 + n][1 + m];
        for (int[] p : puddles) {
            chk[p[1]][p[0]] = true;
        }

        int[][] dp = new int[1 + n][1 + m];
        dp[0][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (chk[i][j]) continue;
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}
