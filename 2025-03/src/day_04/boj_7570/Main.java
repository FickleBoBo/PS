package day_04.BOJ_7570;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 연속하는 수로 이루어진 LIS의 길이를 저장
        int[] dp = new int[1 + N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[num] = dp[num - 1] + 1;
        }

        int len = 0;
        for (int i = 1; i <= N; i++) {
            len = Math.max(len, dp[i]);
        }

        System.out.println(N - len);
    }
}
