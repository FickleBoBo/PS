package day_02.BOJ_1516;

import java.io.*;
import java.util.*;

public class Main {
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

        int[] indegree = new int[1 + N];

        int[] weight = new int[1 + N];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int token = Integer.parseInt(st.nextToken());
                if (token == -1) break;

                adj.get(token).add(i);
                indegree[i]++;
            }
        }

        int[] dist = topologicalSort(N, adj, indegree, weight);
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int[] topologicalSort(int N, List<List<Integer>> adj, int[] indegree, int[] weight) {
        int[] dist = new int[1 + N];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dist[i] = weight[i];
            }
        }

        while (!q.isEmpty()) {
            int node = q.remove();

            for (int next : adj.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);

                dist[next] = Math.max(dist[next], dist[node] + weight[next]);
            }
        }

        return dist;
    }

}
