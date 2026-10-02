package day_13.SWEA_2001;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(Solution.class.getResourceAsStream("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;

                    for (int a = i; a < i + M; a++) {
                        for (int b = j; b < j + M; b++) {
                            sum += map[a][b];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
