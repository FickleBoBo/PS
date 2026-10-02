package day_14.BOJ_22869;

import java.io.*;
import java.util.*;

public class Main_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] dp = new boolean[1 + N];
        dp[1] = true;
        for (int i = 1; i <= N; i++) {
            if (!dp[i]) continue;

            for (int j = i + 1; j <= N; j++) {
                if ((j - i) * (1 + Math.abs(arr[i] - arr[j])) <= K) dp[j] = true;
            }
        }

        if (dp[N]) System.out.println("YES");
        else System.out.println("NO");
    }
}
