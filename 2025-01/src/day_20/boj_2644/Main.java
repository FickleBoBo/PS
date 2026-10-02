package day_20.BOJ_2644;

import java.io.*;
import java.util.*;

public class Main_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int dist = bfs(x, y, N, adj);
        System.out.println(dist);
    }

    private static int bfs(int x, int y, int N, List<List<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);

        boolean[] visited = new boolean[1 + N];
        visited[x] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.poll();
                if (node == y) return dist;

                for (int next : adj.get(node)) {
                    if (visited[next]) continue;

                    q.offer(next);
                    visited[next] = true;
                }
            }

            dist++;
        }

        return -1;
    }

}
