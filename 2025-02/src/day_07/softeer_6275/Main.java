package day_07.Softeer_6275;

import java.io.*;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    // 상 우 하 좌 사방탐색 배열
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static int H;
    private static int W;
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int r = -1;  // 로봇의 시작 행
        int c = -1;  // 로봇의 시작 열
        int d = -1;  // 로봇의 시작 방향

        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 로봇의 시작 위치와 방향 찾기
        out:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '.') continue;

                int cntVisited = 0;  // 인접한 칸 중 방문한 칸의 개수
                int dirVisited = -1;  // 인접한 칸 중 방문한 칸의 방향

                for (int dir = 0; dir < 4; dir++) {
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (map[nr][nc] == '#') {
                        cntVisited++;
                        dirVisited = dir;
                    }
                }

                // 인접한 칸 중 방문한 칸이 정확히 1개면 시작 위치 후보
                if (cntVisited == 1) {
                    r = i;
                    c = j;
                    d = dirVisited;
                    break out;
                }
            }
        }

        visited = new boolean[H][W];

        sb.append(r + 1).append(" ").append(c + 1).append("\n");
        if (d == 0) sb.append("^").append("\n");
        else if (d == 1) sb.append(">").append("\n");
        else if (d == 2) sb.append("v").append("\n");
        else if (d == 3) sb.append("<").append("\n");

        dfs(r, c, d);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int r, int c, int d) {
        visited[r][c] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
            if (map[nr][nc] == '.' || visited[nr][nc]) continue;

            // 바라보는 방향으로 이동하는 경우
            if (d == dir) {
                sb.append("A");
                dfs(nr + dr[dir], nc + dc[dir], dir);
            }
            // 오른쪽으로 회전 후 이동하는 경우
            else if ((d + 1) % 4 == dir) {
                sb.append("RA");
                dfs(nr + dr[dir], nc + dc[dir], dir);
            }
            // 왼쪽으로 회전 후 이동하는 경우
            else if ((d - 1 + 4) % 4 == dir) {
                sb.append("LA");
                dfs(nr + dr[dir], nc + dc[dir], dir);
            }
        }
    }

}
