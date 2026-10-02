package day_20.BOJ_5014;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int dist = bfs(F, S, G, U, D);
        if (dist == -1) System.out.println("use the stairs");
        else System.out.println(dist);
    }

    private static int bfs(int F, int S, int G, int U, int D) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);

        boolean[] visited = new boolean[1 + F];
        visited[S] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.poll();
                if (node == G) return dist;

                int upstairs = node + U;
                if (upstairs <= F && !visited[upstairs]) {
                    q.offer(upstairs);
                    visited[upstairs] = true;
                }

                int downstairs = node - D;
                if (downstairs >= 1 && !visited[downstairs]) {
                    q.offer(downstairs);
                    visited[downstairs] = true;
                }
            }

            dist++;
        }

        return -1;
    }

}
