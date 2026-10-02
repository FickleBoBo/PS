package day_07.BOJ_18870;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            set.add(n);
        }

        int[] sortedArr = new int[set.size()];
        int idx = 0;
        for (int n : set) {
            sortedArr[idx++] = n;
        }
        Arrays.sort(sortedArr);

        for (int i = 0; i < N; i++) {
            sb.append(binarySearch(sortedArr, arr[i])).append(" ");
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
