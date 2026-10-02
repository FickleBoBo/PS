package day_26.BOJ_1912;

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

        int[] prefixSum = new int[1 + N];
        int min = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
            min = Math.min(min, prefixSum[i - 1]);
            ans = Math.max(ans, prefixSum[i] - min);
        }

        System.out.println(ans);
    }
}
