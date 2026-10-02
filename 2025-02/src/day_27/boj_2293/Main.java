package day_27.BOJ_2293;

import java.io.*;
import java.util.*;

public class Main_2D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[1 + N][1 + K];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i]) dp[i][j] += dp[i][j - coins[i]];
            }
        }

        System.out.println(dp[N][K]);
    }
}
