package day_10.BOJ_S2_1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static boolean[][] adj;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int v = sc.nextInt();
        adj = new boolean[N+1][N+1];

        for(int i=0 ; i<M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = adj[b][a] = true;
        }

        visited = new boolean[N+1];
        DFS(v);
        System.out.println();

        visited = new boolean[N+1];
        BFS(v);

        sc.close();
    }

    private static void DFS(int node) {
        // 종료 조건
        if(visited[node]) return;

        // 재귀 조건
        System.out.print(node + " ");
        visited[node] = true;
        for(int i=1 ; i<=N ; i++){
            if((!visited[i]) && (adj[node][i])){
                DFS(i);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int item = queue.poll();
            System.out.print(item + " ");

            for(int i=1 ; i<=N ; i++){
                if((!visited[i] && (adj[item][i]))){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}
