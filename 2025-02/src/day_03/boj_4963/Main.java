package day_03.BOJ_4963;

import java.io.*;
import java.util.*;

public class Main_BFS {

    private static final int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            if (W == 0) break;

            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][] visited = new boolean[H][W];
            int cnt = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 0 || visited[i][j]) continue;

                    bfs(i, j, H, W, map, visited);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int r, int c, int H, int W, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});

        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] node = q.remove();

            for (int dir = 0; dir < 8; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (map[nr][nc] == 0 || visited[nr][nc]) continue;

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

}
