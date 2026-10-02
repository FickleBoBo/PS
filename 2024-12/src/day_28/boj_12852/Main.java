package day_28.BOJ_12852;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1 + N];
        int[] before = new int[1 + N];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;

            if (i % 2 == 0 && dp[i / 2] < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i / 3] < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
        }

        sb.append(dp[N]).append("\n");

        int num = N;
        while (num != 0) {
            sb.append(num).append(" ");
            num = before[num];
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
