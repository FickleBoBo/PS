package day_14.BOJ_22869;

import java.io.*;
import java.util.*;

public class Main_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[1 + N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                if ((j - i) * (1 + Math.abs(arr[i] - arr[j])) <= K) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean flag = bfs(N, adj);

        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean bfs(int N, List<List<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] visited = new boolean[1 + N];
        visited[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node == N) return true;

            for (int next : adj.get(node)) {
                if (visited[next]) continue;

                q.offer(next);
                visited[next] = true;
            }
        }

        return false;
    }

}
