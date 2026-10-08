package day_01.boj_3197;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n, m;
    static char[][] grid;
    static List<int[]> pos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L') pos.add(new int[]{i, j});
            }
        }

        boolean[][] vis = new boolean[n][m];
        int[][] mark = new int[n][m];
        Queue<int[]> ice = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 'X' && !vis[i][j]) {
                    Queue<int[]> res = bfs(i, j, vis);
                    ice.addAll(res);
                }
            }
        }
        bfs(ice, vis, mark);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, mark[i][j]);
            }
        }

        System.out.println(lowerBound(max, mark));
    }

    static Queue<int[]> bfs(int sr, int sc, boolean[][] vis) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        vis[sr][sc] = true;

        Queue<int[]> ice = new ArrayDeque<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (vis[nr][nc]) continue;
                if (grid[nr][nc] == 'X') {
                    ice.offer(new int[]{nr, nc});
                    vis[nr][nc] = true;
                    continue;
                }

                q.offer(new int[]{nr, nc});
                vis[nr][nc] = true;
            }
        }

        return ice;
    }

    static void bfs(Queue<int[]> q, boolean[][] vis, int[][] mark) {
        int dist = 1;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int[] cur = q.poll();
                mark[cur[0]][cur[1]] = dist;

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (grid[nr][nc] != 'X' || vis[nr][nc]) continue;

                    q.offer(new int[]{nr, nc});
                    vis[nr][nc] = true;
                }
            }

            dist++;
        }
    }

    static int lowerBound(int max, int[][] mark) {
        int lo = 0, hi = max;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (!bfs(mid, mark)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }

    static boolean bfs(int max, int[][] mark) {
        int sr = pos.get(0)[0];
        int sc = pos.get(0)[1];
        int er = pos.get(1)[0];
        int ec = pos.get(1)[1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        boolean[][] vis = new boolean[n][m];
        vis[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == er && cur[1] == ec) return true;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (mark[nr][nc] > max || vis[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                vis[nr][nc] = true;
            }
        }

        return false;
    }
}
