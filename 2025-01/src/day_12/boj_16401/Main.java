package day_12.BOJ_16401;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

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
            if (mid == 0) return mid;

            int cnt = count(arr, mid);

            if (cnt >= target) low = mid + 1;
            else high = mid;
        }

        return high - 1;
    }

    private static int count(int[] arr, int len) {
        int cnt = 0;
        for (int n : arr) {
            cnt += n / len;
        }
        return cnt;
    }

}
