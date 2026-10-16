package day_11.boj_2294;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[1 + k];
        Arrays.fill(dp, 1, k + 1, INF);  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 사용한 동전은 0개
        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
            }
        }

        if (dp[k] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
