package day_10.BOJ_1774;

import java.io.*;
import java.util.*;

public class Main {

    private static class Edge implements Comparable<Edge> {
        int a;
        int b;
        double w;

        public Edge(int a, int b, double w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
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
        int M = Integer.parseInt(st.nextToken());

        int[][] pos = new int[1 + N][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                edges.add(new Edge(i, j, dist(pos[i], pos[j])));
            }
        }

        p = make(N);
        int connectCnt = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) continue;

            union(a, b);
            connectCnt++;
        }

        double ans = kruskal(N, connectCnt, edges);
        System.out.printf("%.2f", ans);
    }

    private static double dist(int[] pos1, int[] pos2) {
        return Math.sqrt(Math.pow(pos1[0] - pos2[0], 2) + Math.pow(pos1[1] - pos2[1], 2));
    }

    private static double kruskal(int N, int connectCnt, PriorityQueue<Edge> edges) {
        double sum = 0;
        int cnt = 0;

        while (!edges.isEmpty()) {
            Edge e = edges.remove();
            if (find(e.a) == find(e.b)) continue;

            union(e.a, e.b);
            sum += e.w;
            cnt++;

            if (cnt == N - 1 - connectCnt) return sum;
        }

        return -1;
    }

}
