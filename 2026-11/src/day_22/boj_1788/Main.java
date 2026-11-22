package day_22.boj_1788;

import java.io.*;

public class Main {

    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n >= 0) {
            int[] dp = new int[1 + n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }

            System.out.println(Integer.signum(dp[n]));
            System.out.println(dp[n]);
        } else {
            n = Math.abs(n);
            int[] dp = new int[1 + n];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 2] - dp[i - 1]) % MOD;
            }

            System.out.println(Integer.signum(dp[n]));
            System.out.println(Math.abs(dp[n]));
        }
    }
}
