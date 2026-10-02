package day_06.BOJ_G4_1197;

import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{
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

    // 유니온 파인드 알고리즘의 부모 배열
    static int[] p;

    // find-set
    private static int find(int x){
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    // union-set
    private static void union(int x, int y){
        p[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for(int i=0 ; i<E ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges.offer(new Edge(A, B, C));
        }

        // make-set
        p = new int[1+V];
        for(int i=1 ; i<=V ; i++) p[i] = i;

        int sum = 0;
        int cnt = 0;

        // 크루스칼 알고리즘
        while(!edges.isEmpty()){
            Edge edge = edges.poll();

            int x = find(edge.a);
            int y = find(edge.b);

            if(x == y) continue;

            union(x, y);
            sum += edge.w;
            cnt++;

            if(cnt == V-1) break;
        }

        System.out.println(sum);
    }
}
