package day_04.BOJ_10178;

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
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb
                    .append("You get ")
                    .append(c / v)
                    .append(" piece(s) and your dad gets ")
                    .append(c % v)
                    .append(" piece(s).\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
