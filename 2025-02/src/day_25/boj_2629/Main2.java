package day_25.BOJ_2629;

import java.io.*;
import java.util.*;

public class Main_TopDown_DP {

    private static int N;
    private static int[] weight;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int max = 0;
        weight = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            max += weight[i];
        }

        dp = new boolean[1 + N][1 + max];
        recur(0, 0);

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

    private static void recur(int n, int w) {
        if (dp[n][w]) return;
        dp[n][w] = true;

        if (n == N) return;

        recur(n + 1, w);
        recur(n + 1, w + weight[n + 1]);
        recur(n + 1, Math.abs(w - weight[n + 1]));
    }

}
