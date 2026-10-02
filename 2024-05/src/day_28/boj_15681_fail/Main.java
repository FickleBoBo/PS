package day_28.BOJ_G5_15681_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int R;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

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

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<Q ; i++){
            sb.append(BFS(Integer.parseInt(br.readLine())) + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int BFS(int x){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[1+N];

        if(x == R) return N;

        int cnt = N;
        q.offer(R);
        visited[R] = true;
        cnt--;

        visited[x] = true;

        while(!q.isEmpty()){
            int item = q.poll();
            for(int next : adj[item]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    cnt--;
                }
            }
        }

        return cnt;
    }

}
