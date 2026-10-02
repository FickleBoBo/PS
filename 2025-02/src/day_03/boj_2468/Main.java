package day_03.BOJ_2468;

import java.io.*;
import java.util.*;

public class Main_BFS {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int maxHeight = 0;

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int max = 1;
        for (int height = 2; height <= maxHeight; height++) {
            boolean[][] visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] < height || visited[i][j]) continue;

                    bfs(i, j, height, N, map, visited);
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    private static void bfs(int r, int c, int height, int N, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});

        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] node = q.remove();

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[nr][nc] < height || visited[nr][nc]) continue;

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }

}
