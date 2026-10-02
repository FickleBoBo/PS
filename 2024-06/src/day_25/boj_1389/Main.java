package day_25.BOJ_S1_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] adj;

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

        int ans = 0;

        int min = Integer.MAX_VALUE;
        for(int i=N ; i>=1 ; i--){
            int dist = BFS(i);

            if(dist <= min){
                min = dist;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    private static int BFS(int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        boolean[] visited = new boolean[1+N];
        visited[n] = true;

        int ans = 0;

        int dist = 1;
        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();
                ans += dist;

                for(int next : adj[node]){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }

            dist++;
        }

        return ans;
    }

}
