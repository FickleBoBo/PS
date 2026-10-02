package day_07.BOJ_5086;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0) break;

            if (a % b == 0) sb.append("multiple\n");
            else if (b % a == 0) sb.append("factor\n");
            else sb.append("neither\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
