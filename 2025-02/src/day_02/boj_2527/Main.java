package day_02.BOJ_2527;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 4; tc++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());

            if (x2 < x3 || x1 > x4 || y2 < y3 || y1 > y4) {
                sb.append("d\n");
            } else if ((x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3) || (x2 == x3 && y2 == y3) || (x2 == x3 && y1 == y4)) {
                sb.append("c\n");
            } else if ((x1 == x4) || (x2 == x3) || (y1 == y4) || (y2 == y3)) {
                sb.append("b\n");
            } else {
                sb.append("a\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
