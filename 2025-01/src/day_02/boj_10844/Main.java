package day_02.BOJ_10844;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N][10];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0;

        for (int i = 0; i < N - 1; i++) {
            dp[i + 1][0] = dp[i][1] % MOD;
            dp[i + 1][9] = dp[i][8] % MOD;
            for (int j = 1; j < 9; j++) {
                dp[i + 1][j] = (dp[i][j - 1] + dp[i][j + 1]) % MOD;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N - 1][i];
            ans %= MOD;
        }

        System.out.println(ans);
    }
}
