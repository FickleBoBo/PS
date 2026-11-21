package day_21.boj_10093;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        sb.append(Math.max(b - a - 1, 0)).append("\n");
        for (long i = a + 1; i < b; i++) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
