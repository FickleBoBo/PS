package day_12.BOJ_2470;

import java.io.*;
import java.util.*;

public class Main {
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
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans[0] = arr[left];
                ans[1] = arr[right];
            } else {
                if (sum < 0) left++;
                else right--;
            }
        }

        sb.append(ans[0]).append(" ").append(ans[1]);

        bw.write(sb.toString());
        bw.flush();
    }
}
