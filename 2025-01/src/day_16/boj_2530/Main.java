package day_16.BOJ_2530;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int D = Integer.parseInt(br.readLine());

        sb.append((A + (B + (C + D) / 60) / 60) % 24).append(" ").append((B + (C + D) / 60) % 60).append(" ").append((C + D) % 60);

        bw.write(sb.toString());
        bw.flush();
    }
}
