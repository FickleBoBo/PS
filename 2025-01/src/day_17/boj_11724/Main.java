package day_17.BOJ_11724;

import java.io.*;
import java.util.*;

public class Main_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        boolean[] visited = new boolean[1 + N];
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            bfs(i, adj, visited);
            cnt++;
        }

        System.out.println(cnt);
    }

    private static void bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : adj.get(node)) {
                if (visited[next]) continue;

                q.offer(next);
                visited[next] = true;
            }
        }
    }

}
