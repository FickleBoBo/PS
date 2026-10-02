package day_17.BOJ_2667;

import java.io.*;
import java.util.*;

public class Main_BFS {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][N];

        PriorityQueue<Integer> ans = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '0' || visited[i][j]) continue;

                int cnt = bfs(i, j, N, map, visited);
                ans.add(cnt);
            }
        }

        sb.append(ans.size()).append("\n");
        while (!ans.isEmpty()) {
            sb.append(ans.poll()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int bfs(int r, int c, int N, char[][] map, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        visited[r][c] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[nr][nc] == '0' || visited[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
                cnt++;
            }
        }

        return cnt;
    }

}
