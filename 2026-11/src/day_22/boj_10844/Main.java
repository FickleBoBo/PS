package day_22.boj_10844;

import java.io.*;

public class Main {

    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[1 + n][10];
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
            dp[i][9] = dp[i - 1][8];
        }

        long sum = 0;
        for (int j = 0; j <= 9; j++) {
            sum += dp[n][j];
        }

        System.out.println(sum % MOD);
    }
}
