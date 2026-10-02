package day_21.BOJ_11057;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[1 + N][10 + 1];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            for (int j = 9; j >= 0; j--) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j + 1]) % MOD;
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
            sum %= MOD;
        }

        System.out.println(sum);
    }
}
