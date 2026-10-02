package day_01.BOJ_1238;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Node>> adj = new ArrayList<>();
        List<List<Node>> adjReverse = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            adjReverse.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            adj.get(A).add(new Node(B, T));
            adjReverse.get(B).add(new Node(A, T));
        }

        // 각 마을에서 X마을까지 가는 최단 거리 배열
        int[] dist1 = dijkstra(X, N, adjReverse);

        // X마을에서 각 마을까지 가는 최단 거리 배열
        int[] dist2 = dijkstra(X, N, adj);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist1[i] != INF && dist2[i] != INF) {
                max = Math.max(max, dist1[i] + dist2[i]);
            }
        }

        System.out.println(max);
    }

    private static int[] dijkstra(int start, int N, List<List<Node>> adj) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        boolean[] visited = new boolean[1 + N];

        int[] dist = new int[1 + N];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            if (visited[node.v]) continue;
            visited[node.v] = true;

            for (Node next : adj.get(node.v)) {
                if (visited[next.v]) continue;

                if (dist[next.v] > dist[node.v] + next.w) {
                    dist[next.v] = dist[node.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

}
