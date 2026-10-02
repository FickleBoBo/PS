package day_29.BOJ_P5_2887;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int v;

        public Edge(int a, int b, int v) {
            this.a = a;
            this.b = b;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.v, o.v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] pos = new int[N][4];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            pos[i][0] = i + 1;
            pos[i][1] = Integer.parseInt(st.nextToken());
            pos[i][2] = Integer.parseInt(st.nextToken());
            pos[i][3] = Integer.parseInt(st.nextToken());
        }

        List<Edge> edges = new ArrayList<>();

        Arrays.sort(pos, ((o1, o2) -> {
            return o1[1] - o2[1];
        }));
        for(int i=0 ; i<N-1 ; i++){
            edges.add(new Edge(pos[i][0], pos[i+1][0], Math.abs(pos[i][1] - pos[i+1][1])));
        }

        Arrays.sort(pos, ((o1, o2) -> {
            return o1[2] - o2[2];
        }));
        for(int i=0 ; i<N-1 ; i++){
            edges.add(new Edge(pos[i][0], pos[i+1][0], Math.abs(pos[i][2] - pos[i+1][2])));
        }

        Arrays.sort(pos, ((o1, o2) -> {
            return o1[3] - o2[3];
        }));
        for(int i=0 ; i<N-1 ; i++){
            edges.add(new Edge(pos[i][0], pos[i+1][0], Math.abs(pos[i][3] - pos[i+1][3])));
        }

        Collections.sort(edges);

        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }

        long sum = 0;
        int cnt = 0;

        for(Edge e : edges){
            int x = find(e.a);
            int y = find(e.b);
            if(x == y) continue;

            union(x, y);
            sum += e.v;
            cnt++;
            if(cnt == N-1) break;
        }

        System.out.println(sum);

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
