package day_12.BOJ_2805;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = binarySearchUpperBound(arr, M);

        System.out.println(maxLen);
    }

    private static int binarySearchUpperBound(int[] arr, int target) {
        int low = 0;
        int high = Integer.MAX_VALUE;

        while (low < high) {
            int mid = low + (high - low) / 2;

            long sum = cut(arr, mid);

            if (sum >= target) low = mid + 1;
            else high = mid;
        }

        return high - 1;
    }

    private static long cut(int[] arr, int len) {
        long sum = 0;
        for (int n : arr) {
            sum += Math.max(n - len, 0);
        }
        return sum;
    }

}
