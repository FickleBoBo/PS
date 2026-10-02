package day_02.BOJ_1005;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] D = new int[1 + N];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adj.add(new ArrayList<>());
            }

            int[] indegree = new int[1 + N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                adj.get(X).add(Y);
                indegree[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            sb.append(topologicalSort(W, D, N, adj, indegree)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int topologicalSort(int target, int[] D, int N, List<List<Integer>> adj, int[] indegree) {
        int[] dist = new int[1 + N];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dist[i] = D[i];
            }
        }

        while (!q.isEmpty()) {
            int node = q.remove();

            for (int next : adj.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);

                dist[next] = Math.max(dist[next], dist[node] + D[next]);
            }
        }

        return dist[target];
    }

}
