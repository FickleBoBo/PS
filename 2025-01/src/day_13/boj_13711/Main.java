package day_13.BOJ_13711;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> A = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.put(i, Integer.parseInt(st.nextToken()));
        }

        Map<Integer, Integer> B = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.put(Integer.parseInt(st.nextToken()), i);
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = B.get(A.get(i)) + 1;
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
