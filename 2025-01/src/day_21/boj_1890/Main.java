package day_21.BOJ_1890;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] map;
    private static long[][] dp;

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

        dp = new long[N][N];

        long ans = recur(0, 0);
        System.out.println(ans);
    }

    private static long recur(int r, int c) {
        long cnt = 0;
        if (r == N - 1 && c == N - 1) return 1;
        if (dp[r][c] != 0) return dp[r][c];
        if (map[r][c] == 0) return 0;

        if (r + map[r][c] < N) cnt += dp[r + map[r][c]][c] = recur(r + map[r][c], c);
        if (c + map[r][c] < N) cnt += dp[r][c + map[r][c]] = recur(r, c + map[r][c]);

        return cnt;
    }

}
