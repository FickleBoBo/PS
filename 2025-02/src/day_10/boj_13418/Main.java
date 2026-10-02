package day_10.BOJ_13418;

import java.io.*;
import java.util.*;

public class Main {

    private static class Edge {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    private static int[] p;

    private static int[] make(int N) {
        int[] arr = new int[1 + N];
        for (int i = 1; i <= N; i++) arr[i] = i;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) + 1;

        PriorityQueue<Edge> edges = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
        PriorityQueue<Edge> edgesReverse = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.w, o1.w));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = 1 - Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, W));
            edgesReverse.add(new Edge(A, B, W));
        }

        int min = kruskal(N, edges);
        int max = kruskal(N, edgesReverse);
        System.out.println(max - min);
    }

    private static int kruskal(int N, PriorityQueue<Edge> edges) {
        p = make(N);

        int sum = 0;
        int cnt = 0;

        while (!edges.isEmpty()) {
            Edge e = edges.remove();
            if (find(e.a) == find(e.b)) continue;

            union(e.a, e.b);
            sum += e.w;
            cnt++;

            if (cnt == N) return sum * sum;
        }

        return -1;
    }

}
