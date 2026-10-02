package day_12.BOJ_12015;

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

        int[] dp = new int[1 + N];
        int len = 0;
        for (int i = 0; i < N; i++) {
            int idx = binarySearchLowerBound(dp, len, arr[i]);
            dp[idx] = arr[i];
            if (idx == len + 1) len++;
        }

        System.out.println(len);
    }

    private static int binarySearchLowerBound(int[] arr, int len, int target) {
        int left = 1;
        int right = len + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }

        return right;
    }

}
