package day_17.BOJ_2606;

import java.io.*;
import java.util.*;

public class Main_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

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

        int cnt = bfs(N, adj);
        System.out.println(cnt);
    }

    private static int bfs(int N, List<List<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] visited = new boolean[1 + N];
        visited[1] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : adj.get(node)) {
                if (visited[next]) continue;

                q.offer(next);
                visited[next] = true;
                cnt++;
            }
        }

        return cnt;
    }

}
