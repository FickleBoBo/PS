package day_10.BOJ_10423;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 발전소가 설치된 도시 저장
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, W));
        }

        int ans = kruskal(N, edges, set);
        System.out.println(ans);
    }

    private static int kruskal(int N, PriorityQueue<Edge> edges, Set<Integer> set) {
        p = make(N);

        int sum = 0;
        int cnt = 0;

        while (!edges.isEmpty()) {
            Edge e = edges.remove();
            int fa = find(e.a);
            int fb = find(e.b);

            if (fa == fb) continue;

            // 두 도시의 조상이 모두 발전소면 연결 X
            if (set.contains(fa) && set.contains(fb)) continue;

            // 발전소가 조상이 되도록 유니온
            if (set.contains(fa)) union(e.a, e.b);
            else union(e.b, e.a);

            sum += e.w;
            cnt++;

            if (cnt == N - 1 - (set.size() - 1)) return sum;
        }

        return -1;
    }

}
