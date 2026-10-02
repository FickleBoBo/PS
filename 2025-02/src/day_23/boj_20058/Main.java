package day_23.BOJ_20058;

import java.io.*;
import java.util.*;

public class Main_BFS {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = 1 << Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int L = 1 << Integer.parseInt(st.nextToken());
            int[][] tmp = new int[L][L];

            for (int i = 0; i < N; i += L) {
                for (int j = 0; j < N; j += L) {
                    rotate(i, j, i + L, j + L, L, map, tmp);
                }
            }

            remove(N, map);
        }

        int sum = 0;
        int max = 0;

        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];

                if (map[i][j] == 0 || visited[i][j]) continue;

                int result = bfs(i, j, N, map, visited);
                max = Math.max(max, result);
            }
        }

        System.out.println(sum);
        System.out.println(max);
    }

    private static void rotate(int r1, int c1, int r2, int c2, int L, int[][] map, int[][] tmp) {
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                tmp[(j - c1)][L - 1 - (i - r1)] = map[i][j];
            }
        }

        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                map[i][j] = tmp[(i - r1)][(j - c1)];
            }
        }
    }

    private static void remove(int N, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;

                int cnt = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (map[nr][nc] > 0) cnt++;
                }

                if (cnt < 3) q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.remove();
            map[node[0]][node[1]]--;
        }
    }

    private static int bfs(int r, int c, int N, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});

        visited[r][c] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] node = q.remove();
            cnt++;

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[nr][nc] == 0 || visited[nr][nc]) continue;

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return cnt;
    }

}
