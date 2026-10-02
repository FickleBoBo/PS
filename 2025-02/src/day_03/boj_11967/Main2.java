package day_03.BOJ_11967;

import java.io.*;
import java.util.*;

public class Main2 {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]>[][] lightMap = new ArrayList[1 + N][1 + N];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                lightMap[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lightMap[x][y].add(new int[]{a, b});
        }

        int cnt = bfs(N, lightMap);
        System.out.println(cnt);
    }

    private static int bfs(int N, List<int[]>[][] lightMap) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1});

        boolean[][] map = new boolean[1 + N][1 + N];
        map[1][1] = true;

        // 불은 켠 방에 대한 방문체크
        boolean[][] visited = new boolean[1 + N][1 + N];
        visited[1][1] = true;

        // 불이 꺼져있었지만 방문할 수 있었던 방에 대한 방문체크
        boolean[][] tmpVisited = new boolean[1 + N][1 + N];

        while (!q.isEmpty()) {
            int[] node = q.remove();

            // 스위치가 있는 방이면 스위치를 켜고 불이 꺼져있었지만 방문할 수 있었던 방이면 방문 진행
            for (int[] light : lightMap[node[0]][node[1]]) {
                if (map[light[0]][light[1]]) continue;

                map[light[0]][light[1]] = true;

                if (tmpVisited[light[0]][light[1]]) {
                    q.add(new int[]{light[0], light[1]});
                    visited[light[0]][light[1]] = true;
                    tmpVisited[light[0]][light[1]] = false;
                }
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
                if (visited[nr][nc]) continue;

                // 불이 켜진 방이면 방문하고 불이 꺼진 방이면 방문할 수 있었던 방으로 방문체크
                if (map[nr][nc]) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    tmpVisited[nr][nc] = false;
                } else {
                    tmpVisited[nr][nc] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j]) cnt++;
            }
        }

        return cnt;
    }

}
