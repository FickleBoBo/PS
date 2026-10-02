package day_23.BOJ_20166;

import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static final int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static char[][] matrix;
    private static final Map<String, Integer> cntMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    dfs(i, j, new StringBuilder(), 0, k);
                }
            }
        }

        for (int tc = 1; tc <= K; tc++) {
            sb.append(cntMap.getOrDefault(br.readLine(), 0)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int r, int c, StringBuilder str, int len, int maxLen) {
        str.append(matrix[r][c]);

        if (len == maxLen) {
            cntMap.put(str.toString(), cntMap.getOrDefault(str.toString(), 0) + 1);
            return;
        }

        for (int dir = 0; dir < 8; dir++) {
            int nr = (r + dr[dir] + N) % N;
            int nc = (c + dc[dir] + M) % M;

            dfs(nr, nc, str, len + 1, maxLen);
            str.deleteCharAt(str.length() - 1);
        }
    }

}
