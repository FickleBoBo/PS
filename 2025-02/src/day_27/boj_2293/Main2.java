package day_27.BOJ_2293;

import java.io.*;
import java.util.*;

public class Main_1D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[1 + K];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= coins[i]) dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[K]);
    }
}
