package day_06.boj_10816;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, x) - lowerBound(arr, x)).append(" ");
        }

        System.out.println(sb);
    }

    static int lowerBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }

    static int upperBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }
}
