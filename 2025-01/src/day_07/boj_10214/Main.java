package day_07.BOJ_10214;

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

            int Y = 0;
            int K = 0;
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                Y += Integer.parseInt(st.nextToken());
                K += Integer.parseInt(st.nextToken());
            }

            if (Y > K) sb.append("Yonsei\n");
            else if (Y < K) sb.append("Korea\n");
            else sb.append("Draw\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
