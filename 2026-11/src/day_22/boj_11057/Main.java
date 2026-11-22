package day_22.boj_11057;

import java.io.*;

public class Main {

    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[1 + n][10];
        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= MOD;
            }
        }

        int sum = 0;
        for (int j = 0; j <= 9; j++) {
            sum += dp[n][j];
        }

        System.out.println(sum % MOD);
    }
}
