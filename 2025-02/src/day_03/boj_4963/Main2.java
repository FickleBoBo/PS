package day_03.BOJ_4963;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static final int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    private static int W;
    private static int H;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0) break;

            map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[H][W];
            int cnt = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 0 || visited[i][j]) continue;

                    dfs(i, j);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int dir = 0; dir < 8; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
            if (map[nr][nc] == 0 || visited[nr][nc]) continue;

            dfs(nr, nc);
        }
    }

}
