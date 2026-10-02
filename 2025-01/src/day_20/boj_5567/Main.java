package day_20.BOJ_5567;

import java.io.*;
import java.util.*;

public class Main {
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int cnt = bfs(N, adj);
        System.out.println(cnt);
    }

    private static int bfs(int N, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        boolean[] visited = new boolean[1 + N];
        visited[1] = true;

        int dist = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.poll();

                for (int next : adj.get(node)) {
                    if (visited[next]) continue;

                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }

            dist++;
            if (dist == 2) break;
        }

        return cnt;
    }

}
