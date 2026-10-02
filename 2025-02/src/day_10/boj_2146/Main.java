package day_10.BOJ_2146;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][N];
        int num = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || visited[i][j]) continue;

                int dist = bfs(i, j, num, N, map, visited);
                min = Math.min(min, dist);
                num++;
            }
        }

        System.out.println(min);
    }

    private static int bfs(int r, int c, int num, int N, int[][] map, boolean[][] visited) {
        // 현재 섬의 좌표들을 담는 큐
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});

        visited[r][c] = true;

        // 현재 섬의 경계 바다의 좌표들을 담는 큐
        Queue<int[]> q2 = new ArrayDeque<>();
        boolean[][] visited2 = new boolean[N][N];

        // 현재 섬에 대해 num으로 넘버링하고 경계 바다를 큐에 따로 담는다
        while (!q.isEmpty()) {
            int[] node = q.remove();
            map[node[0]][node[1]] = num;

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;

                // 경계 바다를 발견하면 q2에 담고 방문 체크
                if (map[nr][nc] == 0) {
                    if (!visited2[nr][nc]) {
                        q2.add(new int[]{nr, nc});
                        visited2[nr][nc] = true;
                    }
                    continue;
                }

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        int dist = 0;

        // 현재 섬의 경계 바다부터 현재 섬을 제외한 영역을 탐색
        while (!q2.isEmpty()) {
            int len = q2.size();

            for (int i = 0; i < len; i++) {
                int[] node = q2.remove();

                // 현재 섬이 아닌 육지를 발견하면 종료
                if (map[node[0]][node[1]] != 0) return dist;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (map[nr][nc] == num || visited2[nr][nc]) continue;

                    q2.add(new int[]{nr, nc});
                    visited2[nr][nc] = true;
                }
            }

            dist++;

            // 지금까지 구한 다리의 최소 길이보다 길어지면 종료
            if (dist >= min) return Integer.MAX_VALUE;
        }

        return -1;
    }

}
