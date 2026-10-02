package day_04.BOJ_14248;

import java.io.*;
import java.util.*;

public class Main_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] jump = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            jump[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine()) - 1;

        int cnt = bfs(S, N, jump);
        System.out.println(cnt);
    }

    private static int bfs(int start, int N, int[] jump) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        boolean[] visited = new boolean[N];
        visited[start] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int node = q.remove();

            int jumpLeft = node - jump[node];
            if (jumpLeft >= 0 && !visited[jumpLeft]) {
                q.add(jumpLeft);
                visited[jumpLeft] = true;
                cnt++;
            }

            int jumpRight = node + jump[node];
            if (jumpRight < N && !visited[jumpRight]) {
                q.add(jumpRight);
                visited[jumpRight] = true;
                cnt++;
            }
        }

        return cnt;
    }

}
