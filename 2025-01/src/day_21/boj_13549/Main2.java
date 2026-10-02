package day_21.BOJ_13549;

import java.io.*;
import java.util.*;

public class Main_BFS01 {

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int time = zero_one_bfs(N, K);
        System.out.println(time);
    }

    // 0-1 BFS 알고리즘
    private static int zero_one_bfs(int N, int K) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);

        boolean[] visited = new boolean[1 + MAX];
        visited[N] = true;

        int time = 0;

        while (!dq.isEmpty()) {
            int len = dq.size();

            for (int i = 0; i < len; i++) {
                int node = dq.removeFirst();
                if (node == K) return time;

                // 2*X로 이동하려는 경우로 100,000보다 큰 위치로 이동 X
                if (node * 2 <= MAX && !visited[node * 2]) {
                    dq.addFirst(node * 2);
                    visited[node * 2] = true;

                    // 0인 간선은 카운팅 안하는거 보정
                    i--;
                }

                // X-1로 이동하려는 경우로 0보다 작은 위치로 이동 X
                if (node - 1 >= 0 && !visited[node - 1]) {
                    dq.addLast(node - 1);
                    visited[node - 1] = true;
                }

                // X+1로 이동하려는 경우로 K보다 큰 위치로 이동 X
                if (node + 1 <= K && !visited[node + 1]) {
                    dq.addLast(node + 1);
                    visited[node + 1] = true;
                }
            }

            time++;
        }

        return -1;
    }

}
