package day_06.BOJ_G4_6497;

import java.io.*;
import java.util.*;

public class Main_PriorityQueue {

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 종료 조건
            if(V == 0) break;

            int sum1 = 0;

            PriorityQueue<Edge> edges = new PriorityQueue<>();
            for(int i=0 ; i<E ; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                edges.offer(new Edge(x, y, w));
                sum1 += w;
            }

            // make-set
            p = new int[1+V];
            for(int i=0 ; i<V ; i++) p[i] = i;

            int sum2 = 0;
            int cnt = 0;

            // 크루스칼 알고리즘
            while(!edges.isEmpty()){
                Edge edge = edges.poll();

                int x = find(edge.x);
                int y = find(edge.y);

                if(x == y) continue;

                union(x, y);
                sum2 += edge.w;
                cnt++;

                if(cnt == V-1) break;
            }

            sb.append(sum1 - sum2).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
