package day_21.BOJ_13913;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String ans = bfs(N, K);

        bw.write(ans);
        bw.flush();
    }

    private static String bfs(int N, int K) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        boolean[] visited = new boolean[1 + MAX];
        visited[N] = true;

        // 이전 노드를 기록하는 경로 배열
        int[] before = new int[1 + MAX];
        Arrays.fill(before, Integer.MAX_VALUE);
        before[N] = -1;

        int time = 0;

        out:
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.remove();
                if (node == K) break out;

                // X-1로 이동하려는 경우로 0보다 작은 위치로 이동 X
                if (node - 1 >= 0 && !visited[node - 1]) {
                    q.add(node - 1);
                    visited[node - 1] = true;
                    before[node - 1] = node;
                }

                // X+1로 이동하려는 경우로 K보다 큰 위치로 이동 X
                if (node + 1 <= K && !visited[node + 1]) {
                    q.add(node + 1);
                    visited[node + 1] = true;
                    before[node + 1] = node;
                }

                // 2*X로 이동하려는 경우로 100,000보다 큰 위치로 이동 X
                if (node * 2 <= MAX && !visited[node * 2]) {
                    q.add(node * 2);
                    visited[node * 2] = true;
                    before[node * 2] = node;
                }
            }

            time++;
        }

        // 역순으로 경로 추적
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        sb.append(time).append("\n");

        while (K != -1) {
            stack.push(K);
            K = before[K];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString();
    }

}
