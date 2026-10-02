package day_19.BOJ_21610;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구름의 위치를 담는 Queue
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N - 2, 0});
        q.add(new int[]{N - 2, 1});
        q.add(new int[]{N - 1, 0});
        q.add(new int[]{N - 1, 1});

        // 물복사버그 마법을 사용할 위치를 담는 Queue
        Queue<int[]> q2 = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            move(q, q2, d, s, N, map);
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    private static void move(Queue<int[]> q, Queue<int[]> q2, int d, int s, int N, int[][] map) {
        // 이동한 구름 위치에 대한 방문체크
        boolean[][] visited = new boolean[N][N];

        // 구름의 이동과 방문체크, 비내리기
        int len = q.size();
        for (int i = 0; i < len; i++) {
            int[] node = q.remove();

            // 1번 행, 열과 N번 행, 열이 연결된 처리
            int nr = (node[0] + dr[d] * s + 50 * N) % N;
            int nc = (node[1] + dc[d] * s + 50 * N) % N;

            q.add(new int[]{nr, nc});
            visited[nr][nc] = true;
            map[nr][nc]++;
        }

        // 물복사버그 마법
        len = q.size();
        for (int i = 0; i < len; i++) {
            int[] node = q.remove();

            for (int dir = 1; dir < 8; dir += 2) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[nr][nc] == 0) continue;

                q2.add(node);
            }
        }

        while (!q2.isEmpty()) {
            int[] node = q2.remove();
            map[node[0]][node[1]]++;
        }

        // 새로운 구름 생성
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] < 2 || visited[i][j]) continue;

                q.add(new int[]{i, j});
                map[i][j] -= 2;
            }
        }
    }

}
