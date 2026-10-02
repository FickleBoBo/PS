package day_13.BOJ_G3_4386;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static double[][] pos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        pos = new double[V][2];
        for(int i=0 ; i<V ; i++){
            pos[i][0] = sc.nextDouble();
            pos[i][1] = sc.nextDouble();
        }

        double[][] edges = new double[V*(V-1)/2][3];
        int idx = 0;
        for(int i=0 ; i<V-1 ; i++){
            for(int j=i+1 ; j<V ; j++){
                edges[idx][0] = i;
                edges[idx][1] = j;
                edges[idx][2] = dist(i, j);
                idx++;
            }
        }
        Arrays.sort(edges, (o1, o2) -> {
            return (int) (o1[2] - o2[2]);
        });

        p = new int[V];
        for(int i=0 ; i<V ; i++){
            p[i] = i;
        }

        double ans = 0;
        int cnt = 0;
        for(int i=0 ; i<edges.length ; i++){
            int x = find((int) edges[i][0]);
            int y = find((int) edges[i][1]);

            if(x != y){
                union(x, y);
                ans += edges[i][2];
                cnt++;
                if(cnt == V-1) break;
            }
        }

        System.out.printf("%.2f\n", ans);

        sc.close();
    }

    private static double dist(int i, int j) {
        double x = pos[i][0] - pos[j][0];
        double y = pos[i][1] - pos[j][1];
        return Math.sqrt(x*x + y*y);
    }

    static int[] p;

    private static int find(int x){
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    private static void union(int x, int y){
        p[y] = x;
    }

}
