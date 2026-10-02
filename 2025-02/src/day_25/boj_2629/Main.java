package day_25.BOJ_2629;

import java.io.*;
import java.util.*;

public class Main_BottomUp_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        int[] weight = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            max += weight[i];
        }

        boolean[][] dp = new boolean[1 + N][1 + max];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            dp[i][0] = true;

            for (int j = 1; j <= max; j++) {
                if (dp[i - 1][j]) dp[i][j] = true;
                if (j - weight[i] >= 0 && dp[i - 1][j - weight[i]]) dp[i][j] = true;
                if (dp[i - 1][j]) dp[i][Math.abs(j - weight[i])] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int ball = Integer.parseInt(st.nextToken());

            if (ball > max || !dp[N][ball]) sb.append("N ");
            else sb.append("Y ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
