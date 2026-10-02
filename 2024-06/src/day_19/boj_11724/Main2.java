package day_19.BOJ_S2_11724;

import java.io.*;
import java.util.*;

public class Main_DFS {

    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }

        visited = new boolean[1+N];

        int cnt = 0;
        for(int i=1 ; i<=N ; i++){
            if(!visited[i]){
                DFS(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void DFS(int node){
        visited[node] = true;

        for(int next : adj[node]){
            if(!visited[next]){
                DFS(next);
            }
        }
    }

}
