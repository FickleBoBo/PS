package day_19.BOJ_14442;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int r;
        int c;
        int cntBrokenWall;

        public Node(int r, int c, int cntBrokenWall) {
            this.r = r;
            this.c = c;
            this.cntBrokenWall = cntBrokenWall;
        }
    }

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int dist = bfs(N, M, K, map);
        System.out.println(dist);
    }

    private static int bfs(int N, int M, int K, char[][] map) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0));

        boolean[][][] visited = new boolean[N][M][1 + K];
        visited[0][0][0] = true;

        int dist = 1;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                if (node.r == N - 1 && node.c == M - 1) return dist;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = node.r + dr[dir];
                    int nc = node.c + dc[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                    if (map[nr][nc] == '0') {
                        if (visited[nr][nc][node.cntBrokenWall]) continue;

                        q.offer(new Node(nr, nc, node.cntBrokenWall));
                        visited[nr][nc][node.cntBrokenWall] = true;
                    } else {
                        if (node.cntBrokenWall < K) {
                            if (visited[nr][nc][node.cntBrokenWall + 1]) continue;

                            q.offer(new Node(nr, nc, node.cntBrokenWall + 1));
                            visited[nr][nc][node.cntBrokenWall + 1] = true;
                        }
                    }

                }
            }

            dist++;
        }

        return -1;
    }

}
