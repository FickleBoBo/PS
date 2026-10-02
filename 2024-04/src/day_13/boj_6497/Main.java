package day_13.BOJ_G4_6497;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class Edge implements Comparable<Edge>{
        int x, y, z;

        public Edge(int x, int y, int z) {
            this.x = x; this.y = y; this.z = z;
        }

        @Override
        public int compareTo(Edge o) {
            return this.z - o.z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int V = sc.nextInt();
            int E = sc.nextInt();

            if(V==0 && E==0) break;

            int ans = 0;

            Edge[] edges = new Edge[E];
            for(int i=0 ; i<E ; i++){
                edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
                ans += edges[i].z;
            }
            Arrays.sort(edges);

            p = new int[V];
            for(int i=0 ; i<V ; i++){
                p[i] = i;
            }

            int cnt = 0;
            for(int i=0 ; i<E ; i++){
                int x = find(edges[i].x);
                int y = find(edges[i].y);

                if(x != y){
                    union(x, y);
                    ans -= edges[i].z;
                    cnt++;
                    if(cnt == V-1) break;
                }
            }

            System.out.println(ans);

        }
        sc.close();
    }

    static int[] p;

    private static int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    private static void union(int x, int y){
        p[y] = x;
    }

}
