package day_14.BOJ_G4_1922;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static class Edge implements Comparable<Edge>{
        int st, ed, w;

        public Edge(int st, int ed, int w) {
            this.st = st;
            this.ed = ed;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w-o.w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "st=" + st +
                    ", ed=" + ed +
                    ", w=" + w +
                    '}';
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List[] edges = new ArrayList[V+1];
        for(int i=1 ; i<=V ; i++){
            edges[i] = new ArrayList<Edge>();
        }

        for(int i=0 ; i<E ; i++){
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int w = sc.nextInt();

            edges[st].add(new Edge(st, ed, w));
            edges[ed].add(new Edge(ed, st, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        visited[1] = true;
        pq.addAll(edges[1]);
        // System.out.println(pq.peek().toString());
        int ans = 0;
        int cnt = 1;
        while(cnt < V){
            Edge e = pq.poll();
            // System.out.println(pq.peek().toString());
            if(visited[e.ed]) continue;

            visited[e.ed] = true;
            ans += e.w;
            cnt++;
            pq.addAll(edges[e.ed]);
        }

        System.out.println(ans);

        sc.close();
    }
}
