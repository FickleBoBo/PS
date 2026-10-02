package day_21.BOJ_1697;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int time = bfs(N, K);
        System.out.println(time);
    }

    private static int bfs(int N, int K) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        boolean[] visited = new boolean[1 + MAX];
        visited[N] = true;

        int time = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.remove();
                if (node == K) return time;

                // X-1로 이동하려는 경우로 0보다 작은 위치로 이동 X
                if (node - 1 >= 0 && !visited[node - 1]) {
                    q.add(node - 1);
                    visited[node - 1] = true;
                }

                // X+1로 이동하려는 경우로 K보다 큰 위치로 이동 X
                if (node + 1 <= K && !visited[node + 1]) {
                    q.add(node + 1);
                    visited[node + 1] = true;
                }

                // 2*X로 이동하려는 경우로 100,000보다 큰 위치로 이동 X
                if (node * 2 <= MAX && !visited[node * 2]) {
                    q.add(node * 2);
                    visited[node * 2] = true;
                }
            }

            time++;
        }

        return -1;
    }

}
