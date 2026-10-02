package day_10.BOJ_16398;

import java.io.*;
import java.util.*;

public class Main {

    private static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    private static int[] p;

    private static int[] make(int N) {
        int[] arr = new int[N];
        for (int i = 1; i < N; i++) arr[i] = i;
        return arr;
    }

    private static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    private static void union(int x, int y) {
        p[find(y)] = find(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int w = Integer.parseInt(st.nextToken());
                if (i < j) edges.add(new Edge(i, j, w));
            }
        }

        long ans = kruskal(N, edges);
        System.out.println(ans);
    }

    private static long kruskal(int N, PriorityQueue<Edge> edges) {
        p = make(N);

        long sum = 0;
        int cnt = 0;

        while (!edges.isEmpty()) {
            Edge e = edges.remove();
            if (find(e.a) == find(e.b)) continue;

            union(e.a, e.b);
            sum += e.w;
            cnt++;

            if (cnt == N - 1) return sum;
        }

        // N = 1인 경우 비용은 0
        return 0;
    }

}
