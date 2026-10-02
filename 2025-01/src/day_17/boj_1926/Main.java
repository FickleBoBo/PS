package day_17.BOJ_1926;

import java.io.*;
import java.util.*;

public class Main_BFS {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || visited[i][j]) continue;

                int result = bfs(i, j, N, M, map, visited);
                max = Math.max(max, result);
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    private static int bfs(int r, int c, int N, int M, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        visited[r][c] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            cnt++;

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 0 || visited[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return cnt;
    }

}
