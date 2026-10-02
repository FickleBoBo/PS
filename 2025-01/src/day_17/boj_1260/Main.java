package day_17.BOJ_1260;

import java.io.*;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            adj.get(i).sort(Comparator.naturalOrder());
        }

        visited = new boolean[1 + N];
        dfs(V, adj);
        sb.append("\n");

        visited = new boolean[1 + N];
        bfs(V, adj);
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int node, List<List<Integer>> adj) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int next : adj.get(node)) {
            if (visited[next]) continue;

            dfs(next, adj);
        }
    }

    private static void bfs(int start, List<List<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");

            for (int next : adj.get(node)) {
                if (visited[next]) continue;

                q.offer(next);
                visited[next] = true;
            }
        }
    }

}
