package day_23.BOJ_7569;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0, 0, 0};
    private static final int[] dc = {0, 1, 0, -1, 0, 0};
    private static final int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][N][M];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int result = bfs(N, M, H, map);
        System.out.println(result);
    }

    private static int bfs(int N, int M, int H, int[][][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[H][N][M];
        int leftTomato = 0;

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][i][j] == 1) {
                        q.add(new int[]{i, j, k});
                        visited[k][i][j] = true;
                    } else if (map[k][i][j] == 0) {
                        leftTomato++;
                    }
                }
            }
        }

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] node = q.remove();

                for (int dir = 0; dir < 6; dir++) {
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];
                    int nh = node[2] + dh[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H) continue;
                    if (map[nh][nr][nc] != 0 || visited[nh][nr][nc]) continue;

                    q.add(new int[]{nr, nc, nh});
                    visited[nh][nr][nc] = true;
                    leftTomato--;
                }
            }

            dist++;
        }

        if (leftTomato == 0) return dist - 1;
        else return -1;
    }

}
