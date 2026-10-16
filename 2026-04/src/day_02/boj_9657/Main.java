package day_02.boj_9657;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[1 + 1000];
        dp[1] = dp[3] = dp[4] = true;
        for (int i = 5; i <= n; i++) {
            if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) {
                dp[i] = true;
            }
        }

        if (dp[n]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
