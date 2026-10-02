package day_21.BOJ_12851;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ans = bfs(N, K);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    private static int[] bfs(int N, int K) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        // 방문 체크 배열은 방문한 시간을 저장
        int[] visited = new int[1 + MAX];
        Arrays.fill(visited, 1 + MAX);
        visited[N] = 0;

        boolean flag = false;
        int time = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.remove();
                if (node == K) {
                    flag = true;
                    cnt++;
                }

                // X-1로 이동하려는 경우로 0보다 작은 위치로 이동 X
                if (node - 1 >= 0 && visited[node - 1] >= time) {
                    q.add(node - 1);
                    visited[node - 1] = time;
                }

                // X+1로 이동하려는 경우로 K보다 큰 위치로 이동 X
                if (node + 1 <= K && visited[node + 1] >= time) {
                    q.add(node + 1);
                    visited[node + 1] = time;
                }

                // 2*X로 이동하려는 경우로 100,000보다 큰 위치로 이동 X
                if (node * 2 <= MAX && visited[node * 2] >= time) {
                    q.add(node * 2);
                    visited[node * 2] = time;
                }
            }

            if (flag) return new int[]{time, cnt};
            time++;
        }

        return null;
    }

}
