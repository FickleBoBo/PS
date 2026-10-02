package day_10.BOJ_9466;

import java.io.*;
import java.util.*;

public class Main_TopologicalSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] adj = new int[1 + N];
            int[] indegree = new int[1 + N];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int token = Integer.parseInt(st.nextToken());

                adj[i] = token;
                indegree[token]++;
            }

            int sorted = topologicalSort(N, adj, indegree);
            sb.append(sorted).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // 사이클을 이루지 못한 노드의 개수를 반환
    private static int topologicalSort(int N, int[] adj, int[] indegree) {
        int cnt = 0;

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) if (indegree[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int node = q.remove();
            cnt++;

            indegree[adj[node]]--;
            if (indegree[adj[node]] == 0) q.add(adj[node]);
        }

        return cnt;
    }

}
