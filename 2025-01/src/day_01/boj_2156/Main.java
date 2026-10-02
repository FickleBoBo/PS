package day_01.BOJ_2156;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[3 + N];
        for (int i = 3; i < N + 3; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[3 + N];
        for (int i = 3; i < N + 3; i++) {
            dp[i] = Math.max(Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i], dp[i - 1]);
        }

        System.out.println(dp[N + 2]);
    }
}
