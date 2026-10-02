package day_01.BOJ_1162;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int v;
        long w;
        int cnt;

        public Node(int v, long w, int cnt) {
            this.v = v;
            this.w = w;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }

    private static final long INF = 1_000_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new Node(v, w, 0));
            adj.get(v).add(new Node(u, w, 0));
        }

        long dist = dijkstra(K, N, adj);
        System.out.println(dist);
    }

    private static long dijkstra(int K, int N, List<List<Node>> adj) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, 0));

        boolean[][] visited = new boolean[1 + N][1 + K];

        long[][] dist = new long[1 + N][1 + K];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            if (visited[node.v][node.cnt]) continue;
            visited[node.v][node.cnt] = true;

            for (Node next : adj.get(node.v)) {

                // 도로를 포장하지 않는 경우
                if (!visited[next.v][node.cnt] && (dist[next.v][node.cnt] > dist[node.v][node.cnt] + next.w)) {
                    dist[next.v][node.cnt] = dist[node.v][node.cnt] + next.w;
                    pq.add(new Node(next.v, dist[next.v][node.cnt], node.cnt));
                }

                // 도로를 포장하는 경우
                if ((node.cnt < K) && !visited[next.v][node.cnt + 1] && (dist[next.v][node.cnt + 1] > dist[node.v][node.cnt])) {
                    dist[next.v][node.cnt + 1] = dist[node.v][node.cnt];
                    pq.add(new Node(next.v, dist[next.v][node.cnt + 1], node.cnt + 1));
                }
            }
        }

        // 정확히 K번 포장하는게 최소가 아닐 수 있음
        long min = INF;
        for (int i = 0; i <= K; i++) {
            if (dist[N][i] == INF) continue;
            min = Math.min(min, dist[N][i]);
        }

        return min;
    }

}
