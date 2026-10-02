package day_10.BOJ_G4_16398;

import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int[] p;

    private static int find(int x){
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    private static void union(int x, int y){
        p[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>();

        for(int i=1 ; i<=N ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1 ; j<=N ; j++){
                int w = Integer.parseInt(st.nextToken());

                // 대칭이라 절반만 확인하면 됨
                if(i < j){
                    edges.offer(new Edge(i, j, w));
                }
            }
        }

        p = new int[1+N];
        for(int i=1 ; i<=N ; i++) p[i] = i;

        long sum = 0;
        int cnt = 0;

        while(!edges.isEmpty()){
            Edge e = edges.poll();

            int x = find(e.x);
            int y = find(e.y);

            if(x == y) continue;

            union(x, y);
            sum += e.w;
            cnt++;

            if(cnt == N-1) break;
        }

        System.out.println(sum);
    }
}
