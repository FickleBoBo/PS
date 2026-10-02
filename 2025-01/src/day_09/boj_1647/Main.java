package day_09.BOJ_1647;

import java.io.*;
import java.util.*;

public class Main {

    private static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.c, o.c);
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

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        p = make(N);

        int sum = 0;
        int cnt = 0;
        while (!edges.isEmpty()) {
            if (cnt == N - 2) break;

            Edge e = edges.poll();

            if (find(e.a) == find(e.b)) continue;

            union(e.a, e.b);
            sum += e.c;
            cnt++;
        }

        System.out.println(sum);
    }
}
