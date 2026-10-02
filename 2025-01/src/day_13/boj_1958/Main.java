package day_13.BOJ_1958;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        char[] str3 = br.readLine().toCharArray();

        int N = str1.length;
        int M = str2.length;
        int K = str3.length;

        int[][][] dp = new int[1 + N][1 + M][1 + K];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= K; k++) {
                    if (str1[i - 1] == str2[j - 1] && str1[i - 1] == str3[k - 1]) dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    else dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                }
            }
        }

        System.out.println(dp[N][M][K]);
    }
}
