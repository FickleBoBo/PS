package day_28.BOJ_G2_1766;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer>[] adj = new ArrayList[1+N];
        int[] degree = new int[1+N];

        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<M ; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj[A].add(B);
            degree[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[1+N];

        for(int i=1 ; i<=N ; i++){
            if(degree[i] == 0){
                pq.offer(i);
                visited[i] = true;
            }
        }

        while(!pq.isEmpty()){
            int item = pq.poll();
            System.out.print(item + " ");

            for(int next : adj[item]){
                degree[next]--;
                if(!visited[next] && degree[next] == 0){
                    pq.offer(next);
                    visited[next] = true;
                }
            }
        }

    }
}
