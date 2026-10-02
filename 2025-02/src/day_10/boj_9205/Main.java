package day_10.BOJ_9205;

import java.io.*;
import java.util.*;

public class Main_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] pos = new int[N + 2][2];
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < N + 2; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < N + 1; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (dist(pos[i], pos[j]) <= 1000) {
                        adj.get(i).add(j);
                        adj.get(j).add(i);
                    }
                }
            }

            boolean flag = bfs(N, adj);
            if (flag) sb.append("happy\n");
            else sb.append("sad\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int dist(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }

    private static boolean bfs(int N, List<List<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        boolean[] visited = new boolean[N + 2];
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.remove();
            if (node == N + 1) return true;

            for (int next : adj.get(node)) {
                if (visited[next]) continue;

                q.add(next);
                visited[next] = true;
            }
        }

        return false;
    }

}
