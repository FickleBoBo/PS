package day_23.BOJ_6593;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0, 0, 0};
    private static final int[] dc = {0, 1, 0, -1, 0, 0};
    private static final int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0) break;

            int[] start = null;
            int[] end = null;

            char[][][] map = new char[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    map[i][j] = br.readLine().toCharArray();

                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k] == 'S') start = new int[]{i, j, k};
                        else if (map[i][j][k] == 'E') end = new int[]{i, j, k};
                    }
                }
                br.readLine();
            }

            int dist = bfs(start, end, L, R, C, map);

            if (dist == -1) sb.append("Trapped!\n");
            else sb.append("Escaped in ").append(dist).append(" minute(s).\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int bfs(int[] start, int[] end, int L, int R, int C, char[][][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);

        boolean[][][] visited = new boolean[L][R][C];
        visited[start[0]][start[1]][start[2]] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] node = q.remove();
                if (node[0] == end[0] && node[1] == end[1] && node[2] == end[2]) return dist;

                for (int dir = 0; dir < 6; dir++) {
                    int nh = node[0] + dh[dir];
                    int nr = node[1] + dr[dir];
                    int nc = node[2] + dc[dir];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || nh < 0 || nh >= L) continue;
                    if (!(map[nh][nr][nc] == '.' || map[nh][nr][nc] == 'E') || visited[nh][nr][nc]) continue;

                    q.add(new int[]{nh, nr, nc});
                    visited[nh][nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }

}
