package day_01.BOJ_14938;

import java.io.*;
import java.util.*;

public class Main_Dijkstra {

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
        int R = Integer.parseInt(st.nextToken());

        int[] items = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new Node(v, w));
            adj.get(v).add(new Node(u, w));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, sum(i, items, N, M, adj));
        }

        System.out.println(max);
    }

    private static int sum(int start, int[] items, int N, int M, List<List<Node>> adj) {
        int sum = 0;

        int[] dist = dijkstra(start, N, adj);
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) {
                sum += items[i];
            }
        }

        return sum;
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
