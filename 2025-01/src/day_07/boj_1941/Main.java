package day_07.BOJ_1941;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] sel = new int[7];
    private static final boolean[] selected = new boolean[25];
    private static int ans = 0;

    private static final char[][] map = new char[5][5];
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        combination(0, 0, 0);

        System.out.println(ans);
    }

    private static void combination(int idx, int selIdx, int cntY) {
        // 임도연파가 더 많으면 리턴
        if (cntY > 3) return;

        if (selIdx == sel.length) {
            if (bfs(sel[0] / 5, sel[0] % 5)) ans++;
            return;
        }

        for (int i = idx; i < 25; i++) {
            sel[selIdx] = i;

            selected[i] = true;
            if (map[i / 5][i % 5] == 'S') {
                combination(i + 1, selIdx + 1, cntY);
            } else {
                combination(i + 1, selIdx + 1, cntY + 1);
            }
            selected[i] = false;

        }
    }

    // 7명이 가로세로로 인접해있으면 true
    private static boolean bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if (visited[nr][nc]) continue;
                if (!selected[nr * 5 + nc]) continue;

                q.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
                cnt++;
            }
        }

        return cnt == 7;
    }

}
