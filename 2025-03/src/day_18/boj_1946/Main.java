package day_18.BOJ_1946;

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

            int[] arr = new int[1 + N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int rank1 = Integer.parseInt(st.nextToken());
                int rank2 = Integer.parseInt(st.nextToken());
                arr[rank1] = rank2;
            }

            int flag = N;
            int cnt = N;
            for (int i = 1; i < N; i++) {
                flag = Math.min(flag, arr[i]);

                if (flag < arr[i + 1]) cnt--;
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
