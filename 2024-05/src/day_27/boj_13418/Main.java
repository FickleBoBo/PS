package day_27.BOJ_G3_13418;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Edge implements Comparable<Edge> {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for(int i=0 ; i<=M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = 1 - sc.nextInt();
            edges.add(new Edge(a, b, w));
        }

        Collections.sort(edges);

        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }
        int minValue = 0;
        int minCnt = 0;
        for(int i=0 ; i<=M ; i++){
            int x = find(edges.get(i).a);
            int y = find(edges.get(i).b);
            if(x == y) continue;

            union(x, y);
            minValue += edges.get(i).w;
            minCnt++;
            if(minCnt == N) break;
        }

        Collections.sort(edges, Collections.reverseOrder());

        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }
        int maxValue = 0;
        int maxCnt = 0;
        for(int i=0 ; i<=M ; i++){
            int x = find(edges.get(i).a);
            int y = find(edges.get(i).b);
            if(x == y) continue;

            union(x, y);
            maxValue += edges.get(i).w;
            maxCnt++;
            if(maxCnt == N) break;
        }

//        System.out.println(maxValue*maxValue);
//        System.out.println(minValue*minValue);
        System.out.println(maxValue*maxValue - minValue*minValue);
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
