package day_28.BOJ_1261;

import java.io.*;
import java.util.*;

public class Main_Dijkstra {

    private static class Node implements Comparable<Node> {
        int r;
        int c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    private static final int INF = 1_000_000_000;
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

        int dist = dijkstra(N, M, map);
        System.out.println(dist);
    }

    // 다익스트라 알고리즘
    private static int dijkstra(int N, int M, char[][] map) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        boolean[][] visited = new boolean[N][M];

        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            if (node.r == N - 1 && node.c == M - 1) return node.dist;

            if (visited[node.r][node.c]) continue;
            visited[node.r][node.c] = true;

            for (int dir = 0; dir < 4; dir++) {
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;

                if (map[nr][nc] == '0') {
                    if (dist[nr][nc] > dist[node.r][node.c]) {
                        dist[nr][nc] = dist[node.r][node.c];
                        pq.add(new Node(nr, nc, dist[nr][nc]));
                    }
                } else {
                    if (dist[nr][nc] > dist[node.r][node.c] + 1) {
                        dist[nr][nc] = dist[node.r][node.c] + 1;
                        pq.add(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }

        return -1;
    }

}
