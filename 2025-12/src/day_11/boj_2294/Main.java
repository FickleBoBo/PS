package day_11.boj_2294;

import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[1 + n][1 + k];
        Arrays.fill(dp[0], 1, k + 1, INF);  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 사용한 동전은 0개
        for (int i = 1; i <= n; i++) {
            int coin = coins[i];

            for (int j = 1; j <= k; j++) {
                if (j < coin) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - coin] + 1, dp[i - 1][j]);
                }
            }
        }

        if (dp[n][k] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n][k]);
        }
    }
}
