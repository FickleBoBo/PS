package day_27.BOJ_2294;

import java.io.*;
import java.util.*;

public class Main_2D {

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

        int[][] dp = new int[1 + N][1 + K];
        Arrays.fill(dp[0], MAX);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i]) dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
            }
        }

        System.out.println(dp[N][K] == MAX ? -1 : dp[N][K]);
    }
}
