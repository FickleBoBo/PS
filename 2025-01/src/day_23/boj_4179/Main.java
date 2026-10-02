package day_23.BOJ_4179;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] start = null;
        Queue<int[]> fires = new ArrayDeque<>();

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') start = new int[]{i, j};
                else if (map[i][j] == 'F') fires.add(new int[]{i, j});
            }
        }

        int dist = bfs(start, fires, R, C, map);

        if (dist == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(dist);
    }

    private static int bfs(int[] manStart, Queue<int[]> fires, int R, int C, char[][] map) {
        Queue<int[]> manQueue = new ArrayDeque<>();
        manQueue.add(manStart);

        Queue<int[]> fireQueue = new ArrayDeque<>(fires);

        boolean[][] visited = new boolean[R][C];
        visited[manStart[0]][manStart[1]] = true;

        int dist = 0;

        while (!manQueue.isEmpty()) {
            int len = fireQueue.size();

            for (int i = 0; i < len; i++) {
                int[] fire = fireQueue.remove();

                for (int dir = 0; dir < 4; dir++) {
                    int nr = fire[0] + dr[dir];
                    int nc = fire[1] + dc[dir];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (map[nr][nc] == '#' || map[nr][nc] == 'F' || visited[nr][nc]) continue;

                    fireQueue.add(new int[]{nr, nc});
                    map[nr][nc] = 'F';
                }
            }

            len = manQueue.size();

            for (int i = 0; i < len; i++) {
                int[] man = manQueue.remove();
                if (man[0] == 0 || man[0] == R - 1 || man[1] == 0 || man[1] == C - 1) return dist + 1;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = man[0] + dr[dir];
                    int nc = man[1] + dc[dir];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
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
