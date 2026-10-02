package day_27.BOJ_G3_10423;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int value;

        public Edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> constructed = new ArrayList<>();
        for(int i=0 ; i<K ; i++){
            constructed.add(sc.nextInt());
        }

        List<Edge> edges = new ArrayList<>();
        for(int i=0 ; i<M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int value = sc.nextInt();

            edges.add(new Edge(a, b, value));
        }
        Collections.sort(edges);

        p = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            p[i] = i;
        }

        int cnt = 0;
        int ans = 0;
        for(int i=0 ; i<M ; i++){
            int x = find(edges.get(i).a);
            int y = find(edges.get(i).b);

            if(x == y) continue;

            if(constructed.contains(x) && constructed.contains(y)){
                continue;
            }
            else if(constructed.contains(x)){
                union(x, y);
            }
            else if(constructed.contains(y)){
                union(y, x);
            }
            else{
                union(x, y);
            }

            ans += edges.get(i).value;
            cnt++;
//            System.out.println(edges.get(i).value);
//            System.out.println("cnt : " + cnt);
            if(cnt == N - constructed.size()) break;
        }

        System.out.println(ans);

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
