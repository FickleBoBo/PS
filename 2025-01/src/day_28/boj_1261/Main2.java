package day_28.BOJ_1261;

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

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int dist = zero_one_bfs(N, M, map);
        System.out.println(dist);
    }

    // 0-1 BFS 알고리즘
    private static int zero_one_bfs(int N, int M, char[][] map) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 0));

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        int dist = 0;

        while (!dq.isEmpty()) {
            int len = dq.size();

            for (int i = 0; i < len; i++) {
                Node node = dq.removeFirst();
                if (node.r == N - 1 && node.c == M - 1) return dist;

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
