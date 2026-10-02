package day_28.BOJ_G4_21924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<M ; i++){
            sb.append(br.readLine() + " ");
        }
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        List<Edge> edges = new ArrayList<>();
        long sum = 0;
        while(st.hasMoreTokens()){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, v));
            sum += v;
        }
        Collections.sort(edges);

        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }


        int cnt = 0;
        boolean connected = false;

        for(int i=0 ; i<edges.size() ; i++){
            int x = find(edges.get(i).a);
            int y = find(edges.get(i).b);
            if(x == y) continue;

            union(x, y);
            sum -= edges.get(i).v;
            cnt++;
            if(cnt == N-1){
                connected = true;
                break;
            }
        }

        if(connected) System.out.println(sum);
        else System.out.println(-1);
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
