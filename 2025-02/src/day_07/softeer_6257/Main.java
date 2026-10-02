package day_07.Softeer_6257;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N + 1];
        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 1; j > i; j--) {
                dp[i][j] = dp[i][j + 1];
                if (arr[i] > arr[j]) dp[i][j]++;
            }
        }

        // int형 오버플로우 발생 주의
        long cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] < arr[j]) cnt += dp[i][j + 1];
            }
        }

        System.out.println(cnt);
    }
}
