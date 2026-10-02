package day_09.BOJ_23252;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken()) % 2;
            int C = Integer.parseInt(st.nextToken());

            if (B == 0) {
                if (A >= C && (A - C) % 2 == 0) {
                    bw.write("Yes\n");
                } else {
                    bw.write("No\n");
                }
            } else {
                if (A > 0 && A >= C && (A - C) % 2 == 0) {
                    bw.write("Yes\n");
                } else {
                    bw.write("No\n");
                }
            }
        }

        bw.flush();
    }
}
