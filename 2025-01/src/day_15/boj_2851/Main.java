package day_15.BOJ_2851;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int diff = 100;

        int[] dp = new int[1 + 10];
        for (int i = 1; i <= 10; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];

            if ((Math.abs(dp[i] - 100) < diff) || (Math.abs(dp[i] - 100) == diff && (dp[i] > ans))) {
                ans = dp[i];
                diff = Math.abs(dp[i] - 100);
            }
        }

        System.out.println(ans);
    }
}
