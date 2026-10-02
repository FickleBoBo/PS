package day_08.BOJ_17069;

import java.io.*;
import java.util.*;

// 40분 sol
public class Main {

    private static int N;
    private static int[][] map;
    private static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N][N][3];

        long cnt = dfs(0, 1, 0);
        System.out.println(cnt);
    }

    private static long dfs(int r, int c, int d) {
        if (dp[r][c][d] != 0) return dp[r][c][d];
        if (r == N - 1 && c == N - 1) return 1;

        long cnt = 0;

        if ((d != 1) && (c + 1 < N) && (map[r][c + 1] == 0)) {
            cnt += dfs(r, c + 1, 0);
        }

        if ((d != 0) && (r + 1 < N) && (map[r + 1][c] == 0)) {
            cnt += dfs(r + 1, c, 1);
        }

        if ((r + 1 < N) && (c + 1 < N) && (map[r][c + 1] == 0) && (map[r + 1][c] == 0) && (map[r + 1][c + 1] == 0)) {
            cnt += dfs(r + 1, c + 1, 2);
        }

        return dp[r][c][d] = cnt;
    }

}
