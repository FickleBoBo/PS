package day_30.BOJ_14501;

import java.io.*;
import java.util.*;

public class Main_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] t = new int[1 + N];
        int[] p = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + N + 1 + 5];
        for (int i = 1; i <= N; i++) {
            dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N + 1]);
    }
}
