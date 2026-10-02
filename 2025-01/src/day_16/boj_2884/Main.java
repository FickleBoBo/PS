package day_16.BOJ_2884;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sb.append(((H - 1 + 24) + (M + 15) / 60) % 24).append(" ").append((M + 15) % 60);

        bw.write(sb.toString());
        bw.flush();
    }
}
