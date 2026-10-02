package day_01.BOJ_11779;

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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            adj.get(A).add(new Node(B, W));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end, N, adj));
    }

    private static String dijkstra(int start, int end, int N, List<List<Node>> adj) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        boolean[] visited = new boolean[1 + N];

        int[] dist = new int[1 + N];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        int[] before = new int[1 + N];

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            if (node.v == end) {
                StringBuilder sb = new StringBuilder();
                Deque<Integer> stack = new ArrayDeque<>();

                stack.push(node.v);
                while (before[node.v] != 0) {
                    stack.push(before[node.v]);
                    before[node.v] = before[before[node.v]];
                }

                sb.append(dist[node.v]).append("\n");
                sb.append(stack.size()).append("\n");
                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }

                return sb.toString();
            }

            if (visited[node.v]) continue;
            visited[node.v] = true;

            for (Node next : adj.get(node.v)) {
                if (visited[next.v]) continue;

                if (dist[next.v] > dist[node.v] + next.w) {
                    dist[next.v] = dist[node.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                    before[next.v] = node.v;
                }
            }
        }

        return null;
    }

}
