package day_05.Softeer_6246;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;

    // 방문해야하는 지점의 순서를 기록하는 2차원 배열
    private static int[][] pathOrder;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        pathOrder = new int[N][N];
        int[] start = new int[2];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            pathOrder[r][c] = i;

            if (i == 1) {
                start[0] = r;
                start[1] = c;
            }
        }

        // 시작 지점에서 탐색을 시작하며 가장 최근에 방문한 방문해야하는 지점을 order 파라미터로 들고 다님
        dfs(start[0], start[1], 1);

        System.out.println(cnt);
    }

    private static void dfs(int r, int c, int order) {
        visited[r][c] = true;

        // 모든 지점을 방문한 경우
        if (order == M) {
            cnt++;
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (map[nr][nc] == 1 || visited[nr][nc]) continue;

            // 방문해야하는 지점이 아니면 그냥 방문하고 방문해야하는 지점이면 순서가 맞을 경우 방문
            if (pathOrder[nr][nc] == 0) {
                dfs(nr, nc, order);
            } else if (pathOrder[nr][nc] == order + 1) {
                dfs(nr, nc, order + 1);
            }

            // 방문 체크 해제로 모든 방문 가능한 경로 탐색
            visited[nr][nc] = false;
        }
    }

}
