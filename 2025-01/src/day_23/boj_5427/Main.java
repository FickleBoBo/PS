package day_23.BOJ_5427;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            int[] start = null;
            Queue<int[]> fires = new ArrayDeque<>();

            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();

                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '@') start = new int[]{i, j};
                    else if (map[i][j] == '*') fires.add(new int[]{i, j});
                }
            }

            int dist = bfs(start, fires, H, W, map);
            if (dist == -1) sb.append("IMPOSSIBLE\n");
            else sb.append(dist).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int bfs(int[] manStart, Queue<int[]> fires, int H, int W, char[][] map) {
        Queue<int[]> manQueue = new ArrayDeque<>();
        manQueue.add(manStart);

        Queue<int[]> fireQueue = new ArrayDeque<>(fires);

        boolean[][] visited = new boolean[H][W];
        visited[manStart[0]][manStart[1]] = true;

        int dist = 0;

        while (!manQueue.isEmpty()) {
            int len = fireQueue.size();

            for (int i = 0; i < len; i++) {
                int[] fire = fireQueue.remove();

                for (int dir = 0; dir < 4; dir++) {
                    int nr = fire[0] + dr[dir];
                    int nc = fire[1] + dc[dir];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (map[nr][nc] == '#' || map[nr][nc] == '*' || visited[nr][nc]) continue;

                    fireQueue.add(new int[]{nr, nc});
                    map[nr][nc] = '*';
                }
            }

            len = manQueue.size();

            for (int i = 0; i < len; i++) {
                int[] man = manQueue.remove();
                if (man[0] == 0 || man[0] == H - 1 || man[1] == 0 || man[1] == W - 1) return dist + 1;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = man[0] + dr[dir];
                    int nc = man[1] + dc[dir];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (map[nr][nc] != '.' || visited[nr][nc]) continue;

                    manQueue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            dist++;
        }

        return -1;
    }

}
