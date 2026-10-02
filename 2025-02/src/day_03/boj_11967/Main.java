package day_03.BOJ_11967;

import java.io.*;
import java.util.*;

public class Main {

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

        boolean[][] map = new boolean[1 + N][1 + N];
        map[1][1] = true;

        // 스위치를 누른적이 있는지 판단하는 flag로 스위치를 시작점에서 스위치를 더 누를 수 없어질 때까지 반복
        boolean isChanged = true;
        while (isChanged) {
            isChanged = bfs(N, lightMap, map);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j]) cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean bfs(int N, List<int[]>[][] lightMap, boolean[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1});

        boolean[][] visited = new boolean[1 + N][1 + N];
        visited[1][1] = true;

        while (!q.isEmpty()) {
            int[] node = q.remove();

            // 스위치가 있는 방에 도달하면 스위치를 전부 켜고 true 반환, 켠 스위치를 다시 켜지 않도록 리스트 초기화
            if (!lightMap[node[0]][node[1]].isEmpty()) {
                for (int[] light : lightMap[node[0]][node[1]]) {
                    map[light[0]][light[1]] = true;
                }
                lightMap[node[0]][node[1]].clear();
                return true;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = node[0] + dr[dir];
                int nc = node[1] + dc[dir];

                if (nr < 1 || nr > N || nc < 1 || nc > N) continue;
                if (!map[nr][nc] || visited[nr][nc]) continue;

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return false;
    }

}
