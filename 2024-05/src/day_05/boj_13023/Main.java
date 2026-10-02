package day_05.BOJ_G5_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] adj;
    static boolean flag;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        adj = new ArrayList[N];
        for(int i=0 ; i<N ; i++){
            adj[i] = new ArrayList<>();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<M ; i++){
            sb.append(br.readLine() + " ");
        }
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        for(int i=0 ; i<M ; i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        flag = false;
        visited = new boolean[N];
        for(int i=0 ; i<N ; i++){
            visited[i] = true;
            DFS(i, 0);
            visited[i] = false;
            if(flag) break;
        }

        if(flag) System.out.println(1);
        else System.out.println(0);

    }

    private static void DFS(int node, int depth){
        if(depth==4) {
            flag = true;
            return;
        }

        for(int i=0 ; i<adj[node].size() ; i++){
            if(!visited[adj[node].get(i)]){
                visited[adj[node].get(i)] = true;
                DFS(adj[node].get(i), depth+1);
                visited[adj[node].get(i)] = false;
            }
        }
    }

}
