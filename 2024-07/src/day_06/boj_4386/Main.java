package day_06.BOJ_G3_4386;

import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{
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

    // 두 좌표의 거리 반환
    private static double distance(double[] x, double[] y){
        double dx = x[0] - y[0];
        double dy = x[1] - y[1];
        return Math.sqrt(dx*dx + dy*dy);
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

        int N = Integer.parseInt(st.nextToken());

        double[][] nodes = new double[N][2];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            nodes[i][0] = Double.parseDouble(st.nextToken());
            nodes[i][1] = Double.parseDouble(st.nextToken());
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for(int i=0 ; i<N-1 ; i++){
            for(int j=i+1 ; j<N ; j++){
                double[] x = nodes[i];
                double[] y = nodes[j];

                edges.offer(new Edge(i, j, distance(x, y)));
            }
        }

        // make-set
        p = new int[N];
        for(int i=0 ; i<N ; i++) p[i] = i;

        double sum = 0;
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

            if(cnt == N-1) break;
        }

        System.out.printf("%.2f", sum);
    }
}
