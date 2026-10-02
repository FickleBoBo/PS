package day_02.BOJ_16953;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int dist = bfs(A, B);

        if (dist == -1) System.out.println(dist);
        else System.out.println(dist + 1);
    }

    private static int bfs(long A, long B) {
        Queue<Long> q = new ArrayDeque<>();
        q.add(A);

        Set<Long> visited = new HashSet<>();
        visited.add(A);

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                long node = q.remove();

                if (node == B) return dist;

                if (!visited.contains(node * 2) && (node * 2) <= B) {
                    q.add(node * 2);
                    visited.add(node * 2);
                }

                if (!visited.contains(node * 10 + 1) && (node * 10 + 1) <= B) {
                    q.add(node * 10 + 1);
                    visited.add(node * 10 + 1);
                }
            }

            dist++;
        }

        return -1;
    }

}
