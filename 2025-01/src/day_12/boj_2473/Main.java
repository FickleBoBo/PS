package day_12.BOJ_2473;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long[] ans = new long[3];

        for (int i = 0; i < N - 2; i++) {

            int fixed = i;
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[fixed] + arr[left] + arr[right];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    ans[0] = arr[fixed];
                    ans[1] = arr[left];
                    ans[2] = arr[right];
                } else {
                    if (sum < 0) left++;
                    else right--;
                }
            }
        }

        sb.append(ans[0]).append(" ").append(ans[1]).append(" ").append(ans[2]);

        bw.write(sb.toString());
        bw.flush();
    }
}
