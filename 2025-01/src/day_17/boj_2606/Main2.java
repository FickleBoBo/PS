package day_17.BOJ_2606;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static final List<List<Integer>> adj = new ArrayList<>();
    private static boolean[] visited;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

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

        visited = new boolean[1 + N];

        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int next : adj.get(node)) {
            if (visited[next]) continue;

            dfs(next);
            cnt++;
        }
    }

}
