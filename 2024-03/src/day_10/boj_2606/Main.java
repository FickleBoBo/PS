package day_10.BOJ_S3_2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static boolean[][] adj;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {

        // step1 - 입력 받아서 세팅
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adj = new boolean[N][N];
        visited = new boolean[N];

        int connect = sc.nextInt();
        for(int i=0 ; i<connect ; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            adj[a][b] = adj[b][a] = true;
        }

        // BFS 돌리기
        BFS(0);
        for(int i=1 ; i<N ; i++){
            if(visited[i]) cnt++;    // 개수 세기(BFS 안에서 세려다가 안됨;;)
        }
        System.out.println(cnt);
        sc.close();
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int item = queue.poll();
            for(int i=0 ; i<N ; i++){
                if((adj[item][i]) && (!visited[i])){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

    }

}
