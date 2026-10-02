package day_02.BOJ_2056;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

            int len = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int token = Integer.parseInt(st.nextToken());

                adj.get(token).add(i);
                indegree[i]++;
            }
        }

        int ans = topologicalSort(N, adj, indegree, weight);
        System.out.println(ans);
    }

    private static int topologicalSort(int N, List<List<Integer>> adj, int[] indegree, int[] weight) {
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

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i]);
        }
        return max;
    }

}
