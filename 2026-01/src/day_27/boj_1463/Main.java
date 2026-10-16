package day_27.boj_1463;

import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1 + n * 3];
        Arrays.fill(dp, INF);
        dp[1] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }

        System.out.println(dp[n]);
    }
}
