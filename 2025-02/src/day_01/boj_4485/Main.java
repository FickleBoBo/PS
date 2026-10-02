package day_01.BOJ_4485;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int r;
        int c;
        int sum;

        public Node(int r, int c, int sum) {
            this.r = r;
            this.c = c;
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.sum, o.sum);
        }
    }

    private static final int INF = 1_000_000_000;
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int sum = dijkstra(N, map);
            sb.append("Problem ").append(testCase).append(": ").append(sum).append("\n");
            testCase++;
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int dijkstra(int N, int[][] map) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        boolean[][] visited = new boolean[N][N];

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            if (node.r == N - 1 && node.c == N - 1) return node.sum;

            if (visited[node.r][node.c]) continue;
            visited[node.r][node.c] = true;

            for (int dir = 0; dir < 4; dir++) {
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;

                if (dist[nr][nc] > dist[node.r][node.c] + map[nr][nc]) {
                    dist[nr][nc] = dist[node.r][node.c] + map[nr][nc];
                    pq.add(new Node(nr, nc, dist[nr][nc]));
                }
            }
        }

        return -1;
    }

}
