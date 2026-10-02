package day_28.BOJ_9465;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[2][2 + N];
            st = new StringTokenizer(br.readLine());
            for (int i = 2; i < N + 2; i++) {
                map[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 2; i < N + 2; i++) {
                map[1][i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][2 + N];
            for (int j = 2; j < N + 2; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + map[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + map[1][j];
            }

            sb.append(Math.max(dp[0][N + 1], dp[1][N + 1])).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
