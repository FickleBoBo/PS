package day_31.prms_1844;

import java.util.*;

class Solution {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        int[][] dist = new int[n][m];
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (r == n - 1 && c == m - 1) return dist[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (maps[nr][nc] == 0 || dist[nr][nc] != 0) continue;

                q.offer(new int[]{nr, nc});
                dist[nr][nc] = dist[r][c] + 1;
            }
        }

        return -1;
    }
}
