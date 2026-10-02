package day_16.BOJ_2631;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < k; i++) {
                if (arr[i] < arr[k]) dp[k] = Math.max(dp[k], dp[i] + 1);
            }
            max = Math.max(max, dp[k]);
        }

        System.out.println(N - max);
    }
}
