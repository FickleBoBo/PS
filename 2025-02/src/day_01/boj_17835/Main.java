package day_01.BOJ_17835;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node> {
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
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

        List<List<Node>> adjReverse = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjReverse.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjReverse.get(v).add(new Node(u, c));
        }

        PriorityQueue<Node> input = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            input.add(new Node(Integer.parseInt(st.nextToken()), 0));
        }

        long[] result = dijkstra(input, N, adjReverse);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static long[] dijkstra(PriorityQueue<Node> start, int N, List<List<Node>> adj) {
        PriorityQueue<Node> pq = new PriorityQueue<>(start);

        boolean[] visited = new boolean[1 + N];

        long[] dist = new long[1 + N];
        Arrays.fill(dist, INF);
        for (Node node : start) {
            dist[node.v] = 0;
        }

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

        long maxNum = 0;
        long max = Long.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == 0) continue;

            if (dist[i] > max) {
                maxNum = i;
                max = dist[i];
            }
        }

        return new long[]{maxNum, max};
    }

}
