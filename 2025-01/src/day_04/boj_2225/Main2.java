package day_04.BOJ_2225;

import java.io.*;
import java.util.*;

public class Main2 {

    private static final int MOD = 1_000_000_000;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[2 + N][K];

        System.out.println(recur(N + 1, K - 1));
    }

    private static int recur(int N, int K) {
        if (N == 0) return 0;
        if (K == 0) return dp[N][K] = 1;
        if (dp[N][K] != 0) return dp[N][K];

        return dp[N][K] = (recur(N - 1, K) + recur(N, K - 1)) % MOD;
    }

}
