package day_23.BOJ_7576;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(N, M, map);
        System.out.println(result);
    }

    private static int bfs(int N, int M, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int leftTomato = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (map[i][j] == 0) {
                    leftTomato++;
                }
            }
        }

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] node = q.remove();

                for (int dir = 0; dir < 4; dir++) {
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (map[nr][nc] != 0 || visited[nr][nc]) continue;

                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    leftTomato--;
                }
            }

            dist++;
        }

        if (leftTomato == 0) return dist - 1;
        else return -1;
    }

}
