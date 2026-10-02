package day_25.BOJ_1010;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 30;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] dp = new int[1 + MAX][1 + MAX];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= MAX; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[N][M]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
