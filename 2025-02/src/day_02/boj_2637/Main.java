package day_02.BOJ_2637;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int v;
        int cnt;

        public Node(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[1 + N];
        int[] outdegree = new int[1 + N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            adj.get(X).add(new Node(Y, K));
            indegree[Y]++;
            outdegree[X]++;
        }

        int[] cntArr = topologicalSort(N, adj, indegree);
        for (int i = 1; i <= N; i++) {

            // 진출차수가 0인 부품이 기본 부품
            if (outdegree[i] == 0) {
                sb.append(i).append(" ").append(cntArr[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int[] topologicalSort(int N, List<List<Node>> adj, int[] indegree) {
        int[] cntArr = new int[1 + N];
        cntArr[N] = 1;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(N, 1));

        while (!q.isEmpty()) {
            Node node = q.remove();

            for (Node next : adj.get(node.v)) {
                indegree[next.v]--;
                if (indegree[next.v] == 0) q.add(new Node(next.v, cntArr[next.v]));

                cntArr[next.v] += cntArr[node.v] * next.cnt;
            }
        }

        return cntArr;
    }

}
