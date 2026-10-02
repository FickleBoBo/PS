package day_15.BOJ_G5_15681;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] subTreeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        subTreeSize = new int[1+N];
        Arrays.fill(subTreeSize, 1);

        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<N-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            adj[U].add(V);
            adj[V].add(U);
        }

        visited = new boolean[1+N];
        visited[R] = true;
        DFS(R);

        for(int i=0 ; i<Q ; i++){
            sb.append(subTreeSize[Integer.parseInt(br.readLine())]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int DFS(int node){

        for(int next : adj[node]){
            if(!visited[next]){
                visited[next] = true;
                subTreeSize[node] += DFS(next);
            }
        }

        return subTreeSize[node];
    }

}
