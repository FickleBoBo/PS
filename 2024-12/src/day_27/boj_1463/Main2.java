package day_27.BOJ_1463;

import java.io.*;

public class Main_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1 + N];

        for (int i = 2; i <= N; i++) {
            if (i % 6 == 0) dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 3], dp[i / 2])) + 1;
            else if (i % 3 == 0) dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            else if (i % 2 == 0) dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            else dp[i] = dp[i - 1] + 1;
        }

        System.out.println(dp[N]);
    }
}
