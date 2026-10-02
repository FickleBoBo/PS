package day_25.BOJ_9084;

import java.io.*;
import java.util.*;

public class Main_1D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] coins = new int[1 + N];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[1 + M];

            // 0원을 만들 수 있는 경우는 1가지
            dp[0] = 1;

            for (int i = 1; i <= N; i++) {
                // 중복 선택을 위해 앞에서부터 갱신
                for (int j = coins[i]; j <= M; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            sb.append(dp[M]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
