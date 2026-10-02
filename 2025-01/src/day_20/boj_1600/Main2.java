package day_20.BOJ_1600;

import java.io.*;
import java.util.*;

public class Main2 {

    private static class Node {
        int r;
        int c;
        int jump;

        public Node(int r, int c, int jump) {
            this.r = r;
            this.c = c;
            this.jump = jump;
        }
    }

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};
    private static final int[] drh = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] dch = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dist = bfs(H, W, K, map);
        System.out.println(dist);
    }

    private static int bfs(int H, int W, int K, int[][] map) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));

        int[][] visited = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                if (node.r == H - 1 && node.c == W - 1) return dist;

                // 원숭이의 이동 방법
                for (int dir = 0; dir < 4; dir++) {
                    int nr = node.r + dr[dir];
                    int nc = node.c + dc[dir];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (map[nr][nc] == 1 || visited[nr][nc] <= node.jump) continue;

                    q.offer(new Node(nr, nc, node.jump));
                    visited[nr][nc] = node.jump;
                }

                // 말의 이동 방법
                for (int dir = 0; dir < 8; dir++) {
                    int nr = node.r + drh[dir];
                    int nc = node.c + dch[dir];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                    if (node.jump == K) continue;
                    if (map[nr][nc] == 1 || visited[nr][nc] <= node.jump + 1) continue;

                    q.offer(new Node(nr, nc, node.jump + 1));
                    visited[nr][nc] = node.jump + 1;
                }
            }

            dist++;
        }

        return -1;
    }

}
