package day_03.BOJ_11051;

import java.io.*;
import java.util.*;

public class Main_TopDown_DP {

    private static final int MOD = 10007;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[1 + N][1 + K];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        int ans = recur(N, K);
        System.out.println(ans);
    }

    private static int recur(int N, int K) {
        if (dp[N][K] != 0) return dp[N][K];
        if (K == 1) return N;
        if (K == 0 || N == K) return 1;
        return dp[N][K] = (recur(N - 1, K - 1) + recur(N - 1, K)) % MOD;
    }

}
