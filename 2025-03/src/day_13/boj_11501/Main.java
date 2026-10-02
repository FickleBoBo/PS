package day_13.BOJ_11501;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int max = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > max) max = arr[i];
                else sum += max - arr[i];
            }

            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
