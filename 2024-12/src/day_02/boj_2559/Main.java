package day_02.BOJ_2559;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        // 연속된 온도의 합이 음수일 수 있어서 Integer.MIN_VALUE로 초기화
        int ans = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            ans = Math.max(ans, prefixSum[i] - prefixSum[i - K]);
        }

        System.out.println(ans);
    }
}
