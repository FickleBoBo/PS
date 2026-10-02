package day_05.Softeer_6247;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());

            int index = binarySearch(arr, q);

            // 인덱스가 -1 이면 중앙값이 될 수 없는 쿼리
            if (index == -1) {
                sb.append(0).append("\n");
                continue;
            }

            // 중앙값보다 작은 값들의 개수와 큰 값들의 개수의 곱이 서로 다른 경우의 수
            sb.append(index * (N - index - 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) left = mid + 1;
            else if (arr[mid] > target) right = mid - 1;
            else return mid;
        }

        return -1;
    }

}
