package day_06.BOJ_1707;

import java.io.*;
import java.util.*;

public class Main {

    private static final int WHITE = 0;
    private static int RED = -1;
    private static int BLACK = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            boolean isBipartiteGraph = true;
            int[] visited = new int[1 + V];

            for (int i = 1; i <= V; i++) {
                if (visited[i] == WHITE) {
                    boolean result = bfs(i, adj, visited);
                    if (!result) {
                        isBipartiteGraph = false;
                        break;
                    }
                }
            }

            if (isBipartiteGraph) sb.append("YES\n");
            else sb.append("NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean bfs(int start, List<List<Integer>> adj, int[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        visited[start] = RED;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.poll();

                for (int next : adj.get(node)) {
                    if (visited[next] == RED) return false;

                    if (visited[next] == WHITE) {
                        q.offer(next);
                        visited[next] = BLACK;
                    }
                }
            }

            int tmp = RED;
            RED = BLACK;
            BLACK = tmp;
        }

        return true;
    }

}
