package day_29.BOJ_14497;

import java.io.*;
import java.util.*;

public class Main_BFS01 {

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int jump = zero_one_bfs(x1, y1, x2, y2, N, M, map);
        System.out.println(jump);
    }

    // 0-1 BFS 알고리즘
    private static int zero_one_bfs(int x1, int y1, int x2, int y2, int N, int M, char[][] map) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x1, y1));

        boolean[][] visited = new boolean[N][M];
        visited[x1][y1] = true;

        int dist = 0;

        while (!dq.isEmpty()) {
            int len = dq.size();

            for (int i = 0; i < len; i++) {
                Node node = dq.removeFirst();
                if (node.r == x2 && node.c == y2) return dist;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = node.r + dr[dir];
                    int nc = node.c + dc[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (visited[nr][nc]) continue;

                    if (map[nr][nc] == '0') {
                        dq.addFirst(new Node(nr, nc));
                        visited[nr][nc] = true;
                        i--;
                    } else {
                        dq.addLast(new Node(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }

            dist++;
        }

        return -1;
    }

}
