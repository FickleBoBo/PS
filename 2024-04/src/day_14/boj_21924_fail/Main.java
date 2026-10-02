package day_14.BOJ_G4_21924_Fail;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int ans = 0;

        int[][] adj = new int[1+V][1+V];
        for(int i=0 ; i<E ; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();
            adj[A][B] = adj[B][A] = W;
            ans += W;
        }

        boolean[] visited = new boolean[1+V];
        int[] dist = new int[1+V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int node = 1;
        visited[node] = true;
        dist[node] = 0;
        int cost = 0;

        for(int i=2 ; i<=V ; i++){
            for(int j=1 ; j<=V ; j++){
                if(!visited[j] && adj[node][j]>0 && adj[node][j]<dist[j]){
                    dist[j] = adj[node][j];
                }
            }

            int min = Integer.MAX_VALUE;
            int idx = -1;

            for(int j=1 ; j<=V ; j++){
                if(!visited[j] && dist[j] < min){
                    min = dist[j];
                    idx = j;
                }
            }

            if(idx == -1){
                ans = -1;
                cost = 0;
                break;
            }

            node = idx;
            visited[node] = true;
            cost += min;
        }

        System.out.println(ans - cost);

        sc.close();
    }
}
