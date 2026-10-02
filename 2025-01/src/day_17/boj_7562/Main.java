package day_17.BOJ_7562;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int L = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int cnt = bfs(r1, c1, r2, c2, L);
            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int bfs(int r1, int c1, int r2, int c2, int L) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r1, c1});

        boolean[][] visited = new boolean[L][L];
        visited[r1][c1] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] item = q.poll();
                if (item[0] == r2 && item[1] == c2) return dist;

                for (int dir = 0; dir < 8; dir++) {
                    int nr = item[0] + dr[dir];
                    int nc = item[1] + dc[dir];

                    if (nr < 0 || nr >= L || nc < 0 || nc >= L) continue;
                    if (visited[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }

}
