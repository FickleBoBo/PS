package day_02.BOJ_2623;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[1 + N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());

            int A = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int B = Integer.parseInt(st.nextToken());

                adj.get(A).add(B);
                indegree[B]++;
                A = B;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                cnt++;
            }
        }

        while (!q.isEmpty()) {
            int node = q.remove();

            sb.append(node).append("\n");

            for (int next : adj.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                    cnt++;
                }
            }
        }

        // 순서를 정하는게 불가능한 경우
        if (cnt != N) sb = new StringBuilder().append("0");

        bw.write(sb.toString());
        bw.flush();
    }
}
