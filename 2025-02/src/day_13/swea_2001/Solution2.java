package day_13.SWEA_2001;

import java.io.*;
import java.util.*;

public class Solution_DP {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(Solution_DP.class.getResourceAsStream("input.txt")));
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

            int[][] prefixSum = new int[1 + N][1 + N];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + map[i - 1][j - 1];
                }
            }

            int max = 0;
            for (int i = M; i <= N; i++) {
                for (int j = M; j <= N; j++) {
                    max = Math.max(max, prefixSum[i][j] - prefixSum[i - M][j] - prefixSum[i][j - M] + prefixSum[i - M][j - M]);
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
