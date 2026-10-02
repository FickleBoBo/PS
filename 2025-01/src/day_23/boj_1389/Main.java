package day_23.BOJ_1389;

import java.io.*;
import java.util.*;

public class Main_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj.get(A).add(B);
            adj.get(B).add(A);
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            int result = bfs(i, N, adj);

            if (result < min) {
                min = result;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    private static int bfs(int start, int N, List<Set<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        boolean[] visited = new boolean[1 + N];
        visited[start] = true;

        int dist = 0;
        int sum = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.remove();
                sum += dist;

                for (int next : adj.get(node)) {
                    if (visited[next]) continue;

                    q.add(next);
                    visited[next] = true;
                }
            }

            dist++;
        }

        return sum;
    }

}
