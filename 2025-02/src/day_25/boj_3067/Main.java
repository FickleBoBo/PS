package day_25.BOJ_3067;

import java.io.*;
import java.util.*;

public class Main_2D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] coins = new int[1 + N];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[][] dp = new int[1 + N][1 + M];
            for (int i = 1; i <= N; i++) {
                // 0원을 만들 수 있는 경우는 1가지
                dp[i][0] = 1;

                for (int j = 1; j <= M; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= coins[i]) dp[i][j] += dp[i][j - coins[i]];
                }
            }

            sb.append(dp[N][M]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
