package day_12.BOJ_1654;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxLen = binarySearchUpperBound(arr, N);

        System.out.println(maxLen);
    }

    private static int binarySearchUpperBound(int[] arr, int target) {
        long low = 0;
        long high = Integer.MAX_VALUE + 1L;

        while (low < high) {
            long mid = (low + high) / 2;

            int cnt = count(arr, mid);

            if (cnt >= target) low = mid + 1;
            else high = mid;
        }

        return (int) (high - 1);
    }

    private static int count(int[] arr, long len) {
        int cnt = 0;
        for (int n : arr) {
            cnt += (int) (n / len);
        }
        return cnt;
    }

}
