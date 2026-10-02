package day_09.BOJ_21940;

import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1 + N][1 + N];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            dp[A][B] = T;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        int[] kArr = new int[1 + K];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            kArr[i] = Integer.parseInt(st.nextToken());
        }

        // 행은 모든 도시, 열은 준형이와 친구들이 사는 도시
        int[][] dist = new int[1 + N][1 + K];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dist[i][j] += dp[i][kArr[j]] + dp[kArr[j]][i];
            }
            Arrays.sort(dist[i]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            min = Math.min(dist[i][K], min);
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i][K] == min) sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
