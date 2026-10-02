package day_17.BOJ_2667;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static int N;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][N];

        PriorityQueue<Integer> ans = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '0' || visited[i][j]) continue;

                int cnt = dfs(i, j);
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

    private static int dfs(int r, int c) {
        visited[r][c] = true;
        int cnt = 1;

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (map[nr][nc] == '0' || visited[nr][nc]) continue;

            cnt += dfs(nr, nc);
        }

        return cnt;
    }

}
