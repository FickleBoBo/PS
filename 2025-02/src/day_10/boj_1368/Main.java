package day_10.BOJ_1368;

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
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> edges = new PriorityQueue<>();

        // 우물을 파는 것을 0번 논에 연결하는 것으로 간주
        for (int i = 1; i <= N; i++) {
            edges.add(new Edge(0, i, Integer.parseInt(br.readLine())));
        }

        // i번째 논과 j번째 논을 연결하는 비용 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                edges.add(new Edge(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        int ans = kruskal(N, edges);
        System.out.println(ans);
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

            // 0번 논부터 N번 논까지 N개의 간선 필요
            if (cnt == N) return sum;
        }

        return -1;
    }

}
