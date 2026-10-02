package day_15.BOJ_10163;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[1001][1001];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = r1 + Integer.parseInt(st.nextToken()) - 1;
            int c2 = c1 + Integer.parseInt(st.nextToken()) - 1;

            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    map[r][c] = i;
                }
            }
        }

        int[] cntArr = new int[1 + N];
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                cntArr[map[i][j]]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(cntArr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
