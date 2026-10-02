package day_27.boj_2294;

import java.io.*;
import java.util.*;

public class Main2 {

    private static final int MAX = 10001;

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
        for (int i = 1; i <= K; i++) {
            dp[i] = MAX;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= coins[i]) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        System.out.println(dp[K] == MAX ? -1 : dp[K]);
    }
}
