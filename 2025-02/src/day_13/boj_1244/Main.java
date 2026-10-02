package day_13.BOJ_1244;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[] lightArr = new boolean[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lightArr[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = num; j <= N; j += num) {
                    lightArr[j] = !lightArr[j];
                }
            } else {
                lightArr[num] = !lightArr[num];

                int k = 1;
                while ((num - k >= 1) && (num + k <= N) && (lightArr[num - k] == lightArr[num + k])) {
                    lightArr[num - k] = !lightArr[num - k];
                    lightArr[num + k] = !lightArr[num + k];
                    k++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(lightArr[i] ? 1 : 0).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
