package day_20.BOJ_G5_9205;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static boolean[][] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            N = sc.nextInt();
            int[][] input = new int[N+2][2];
            for(int i=0 ; i<N+2 ; i++){
                input[i][0] = sc.nextInt();
                input[i][1] = sc.nextInt();
            }

            adj = new boolean[N+2][N+2];
            for(int i=0 ; i<N+2 ; i++){
                for(int j=0 ; j<N+2 ; j++){
                    adj[i][j] = adj[j][i] = Distance(input, i, j);
                }
            }

            BFS();
        }

        sc.close();
    }

    private static boolean Distance(int[][] arr, int r, int c){
        int x = Math.abs(arr[r][0] - arr[c][0]);
        int y = Math.abs(arr[r][1] - arr[c][1]);
        return x+y <= 1000;
    }

    private static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+2];
        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int item = q.poll();
            for(int i=0 ; i<N+2 ; i++){
                if(!visited[i] && adj[item][i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

        if(visited[N+1]) System.out.println("happy");
        else System.out.println("sad");
    }

}
