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
            if (cur[0] == n - 1 && cur[1] == m - 1) return dist[cur[0]][cur[1]];

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (maps[nr][nc] == 0 || dist[nr][nc] != 0) continue;

                q.offer(new int[]{nr, nc});
                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
            }
        }

        return -1;
    }
}
