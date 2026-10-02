package day_02.BOJ_13023;

import java.io.*;
import java.util.*;

public class Main {

    private static final List<List<Integer>> adj = new ArrayList<>();
    private static boolean[] visited;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj.get(A).add(B);
            adj.get(B).add(A);
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (flag) break;

            dfs(i, 0);
        }

        if (flag) System.out.println(1);
        else System.out.println(0);
    }

    private static void dfs(int node, int depth) {
        if (flag) return;

        if (depth == 4) {
            flag = true;
            return;
        }

        visited[node] = true;

        for (int next : adj.get(node)) {
            if (visited[next]) continue;

            dfs(next, depth + 1);
        }

        visited[node] = false;
    }

}
