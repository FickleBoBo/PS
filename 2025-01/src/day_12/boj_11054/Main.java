package day_12.BOJ_11054;

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

        int max = 0;

        int[] dp1 = new int[N];
        Arrays.fill(dp1, 1);

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < k; i++) {
                if (arr[i] < arr[k]) dp1[k] = Math.max(dp1[k], dp1[i] + 1);
            }
        }

        int[] dp2 = new int[N];
        Arrays.fill(dp2, 1);

        for (int k = N - 1; k >= 0; k--) {
            for (int i = N - 1; i > k; i--) {
                if (arr[i] < arr[k]) dp2[k] = Math.max(dp2[k], dp2[i] + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        System.out.println(max);
    }
}
