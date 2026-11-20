package day_19.prms_49191;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] dp = new boolean[1 + n][1 + n];
        for (int[] r : results) {
            dp[r[0]][r[1]] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dp[i][k] && dp[k][j]) dp[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] || dp[j][i]) cnt++;
            }

            if (cnt == n - 1) ans++;
        }

        return ans;
    }
}
