package day_11.BOJ_2573;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 1;
        while (true) {
            melt();

            visited = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0 || visited[i][j]) continue;

                    dfs(i, j);
                    cnt++;
                }
            }

            if (cnt == 0) {
                day = 0;
                break;
            } else if (cnt >= 2) {
                break;
            }

            day++;
        }

        System.out.println(day);
    }

    private static void melt() {
        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                    if (map[nr][nc] == 0) matrix[i][j]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = Math.max(map[i][j] - matrix[i][j], 0);
            }
        }
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (map[nr][nc] == 0 || visited[nr][nc]) continue;

            dfs(nr, nc);
        }
    }

}
