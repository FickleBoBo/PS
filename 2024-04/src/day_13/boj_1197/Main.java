package day_13.BOJ_G4_1197;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Edge implements Comparable<Edge> {
        int x, y, v;

        public Edge(int x, int y, int v) {
            this.x = x; this.y = y; this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        Edge[] edges = new Edge[E];

        for(int i=0 ; i<E ; i++){
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(edges);

        p = new int[1+V];
        for(int i=1 ; i<=V ; i++){
            p[i] = i;
        }

        int ans = 0;
        int cnt = 0;

        for(int i=0 ; i<E ; i++){
            int x = find(edges[i].x);
            int y = find(edges[i].y);
            if(x != y){
                union(x, y);
                ans += edges[i].v;
                cnt++;
                if(cnt == V-1) break;
            }
        }

        System.out.println(ans);

        sc.close();
    }

    static int[] p;

    private static int find(int x){
        if(x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private static void union(int x, int y){
        p[y] = x;
    }

}
