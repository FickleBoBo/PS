package day_10.BOJ_2887;

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

        // 행성 번호와 좌표를 저장한 배열
        int[][] pos = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = i;
            pos[i][1] = Integer.parseInt(st.nextToken());
            pos[i][2] = Integer.parseInt(st.nextToken());
            pos[i][3] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();

        // x좌표를 기준으로 정렬
        Arrays.sort(pos, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(pos[i][0], pos[i + 1][0], dist(pos[i], pos[i + 1])));
        }
        // y좌표를 기준으로 정렬
        Arrays.sort(pos, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(pos[i][0], pos[i + 1][0], dist(pos[i], pos[i + 1])));
        }
        // z좌표를 기준으로 정렬
        Arrays.sort(pos, (o1, o2) -> Integer.compare(o1[3], o2[3]));
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(pos[i][0], pos[i + 1][0], dist(pos[i], pos[i + 1])));
        }

        long ans = kruskal(N, edges);
        System.out.println(ans);
    }

    private static int dist(int[] pos1, int[] pos2) {
        return Math.min(Math.abs(pos1[1] - pos2[1]), Math.min(Math.abs(pos1[2] - pos2[2]), Math.abs(pos1[3] - pos2[3])));
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

        return -1;
    }

}
