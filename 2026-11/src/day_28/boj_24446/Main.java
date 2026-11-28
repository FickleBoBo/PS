package day_28.boj_24446;

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

        System.out.println(bfs(r));
    }

    static String bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        int[] dist = new int[1 + n];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj[cur]) {
                if (dist[nxt] != -1) continue;
                q.offer(nxt);
                dist[nxt] = dist[cur] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]).append("\n");
        }

        return sb.toString();
    }
}
