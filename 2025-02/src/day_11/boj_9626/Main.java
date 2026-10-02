package day_11.BOJ_9626;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        char[][] words = new char[M][N];
        for (int i = 0; i < M; i++) {
            words[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < U + M + D; i++) {
            for (int j = 0; j < L + N + R; j++) {
                if (U <= i && i < U + M && L <= j && j < L + N) {
                    sb.append(words[i - U][j - L]);
                } else {
                    if ((i + j) % 2 == 0) sb.append("#");
                    else sb.append(".");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
