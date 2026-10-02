package day_03.BOJ_10250;

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
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken()) - 1;

            if (N / H < 9) {
                sb.append(N % H + 1).append(0).append(N / H + 1).append("\n");
            } else {
                sb.append(N % H + 1).append(N / H + 1).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
