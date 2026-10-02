package day_03.BOJ_11725;

import java.io.*;
import java.util.*;

public class Main_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] p = bfs(N, adj);
        for (int i = 2; i <= N; i++) {
            sb.append(p[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int[] bfs(int N, List<List<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        boolean[] visited = new boolean[1 + N];
        visited[1] = true;

        int[] p = new int[1 + N];

        while (!q.isEmpty()) {
            int node = q.remove();

            for (int next : adj.get(node)) {
                if (visited[next]) continue;

                q.add(next);
                visited[next] = true;
                p[next] = node;
            }
        }

        return p;
    }

}
