package day_12.BOJ_3058;

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

            int sum = 0;
            int min = 100;

            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());

                if (n % 2 == 0) {
                    sum += n;
                    min = Math.min(min, n);
                }
            }

            sb.append(sum).append(" ").append(min).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
