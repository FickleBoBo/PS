package day_01.BOJ_1504;

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
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int startToV1 = dijkstra(1, v1, N, adj);
        int v1ToV2 = dijkstra(v1, v2, N, adj);
        int v2ToEnd = dijkstra(v2, N, N, adj);
        int path1 = startToV1 + v1ToV2 + v2ToEnd;
        boolean path1IsValid = startToV1 != -1 && v1ToV2 != -1 && v2ToEnd != -1;

        int startToV2 = dijkstra(1, v2, N, adj);
        int v2ToV1 = dijkstra(v2, v1, N, adj);
        int v1ToEnd = dijkstra(v1, N, N, adj);
        int path2 = startToV2 + v2ToV1 + v1ToEnd;
        boolean path2IsValid = startToV2 != -1 && v2ToV1 != -1 && v1ToEnd != -1;

        if (path1IsValid && path2IsValid) {
            System.out.println(Math.min(path1, path2));
        } else if (path1IsValid) {
            System.out.println(path1);
        } else if (path2IsValid) {
            System.out.println(path2);
        } else {
            System.out.println(-1);
        }
    }

    private static int dijkstra(int start, int end, int N, List<List<Node>> adj) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        boolean[] visited = new boolean[1 + N];

        int[] dist = new int[1 + N];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            if (node.v == end) return dist[node.v];

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

        return -1;
    }

}
