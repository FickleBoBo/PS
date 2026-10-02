package day_14.BOJ_17128;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = arr[0] * arr[1] * arr[2] * arr[3];

        int sum = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] / arr[i - 1] * arr[(i + 3) % N];
            sum += dp[i];
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int q = Integer.parseInt(st.nextToken());

            int idx1 = (q - 4 + N) % N;
            int idx2 = (q - 3 + N) % N;
            int idx3 = (q - 2 + N) % N;
            int idx4 = (q - 1 + N) % N;

            dp[idx1] *= -1;
            dp[idx2] *= -1;
            dp[idx3] *= -1;
            dp[idx4] *= -1;

            sum += dp[idx1] * 2;
            sum += dp[idx2] * 2;
            sum += dp[idx3] * 2;
            sum += dp[idx4] * 2;

            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
