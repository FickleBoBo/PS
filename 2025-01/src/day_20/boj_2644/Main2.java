package day_20.BOJ_2644;

import java.io.*;
import java.util.*;

public class Main_DFS {

    private static boolean[] visited;
    private static final List<List<Integer>> adj = new ArrayList<>();

    private static int dist = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[1 + N];

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

        dfs(x, y, 0);

        System.out.println(dist);
    }

    private static void dfs(int node, int y, int depth) {
        if (dist > 0) return;

        visited[node] = true;
        if (node == y) {
            dist = depth;
            return;
        }

        for (int next : adj.get(node)) {
            if (visited[next]) continue;

            dfs(next, y, depth + 1);
        }
    }

}
