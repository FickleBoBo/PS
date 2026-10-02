package day_05.BOJ_10093;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long A = Math.min(a, b);
        long B = Math.max(a, b);

        sb.append(Math.max(B - A - 1, 0)).append("\n");
        for (long i = A + 1; i < B; i++) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
