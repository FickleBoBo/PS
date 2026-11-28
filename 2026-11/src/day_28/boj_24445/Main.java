package day_28.boj_24445;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        adj = new ArrayList[1 + n];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            adj[i].sort(Comparator.reverseOrder());
        }

        System.out.println(bfs(r));
    }

    static String bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] vis = new boolean[1 + n];
        vis[start] = true;

        int[] order = new int[1 + n];
        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            order[cur] = cnt++;

            for (int nxt : adj[cur]) {
                if (vis[nxt]) continue;
                q.offer(nxt);
                vis[nxt] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }

        return sb.toString();
    }
}
