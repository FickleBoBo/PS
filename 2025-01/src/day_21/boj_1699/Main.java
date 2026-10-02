package day_21.BOJ_1699;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1 + N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= N; i++) {
            dp[i * i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * j < i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
