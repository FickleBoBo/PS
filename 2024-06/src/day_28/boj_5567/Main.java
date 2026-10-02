package day_28.BOJ_S2_5567;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 인접 리스트
        List<Integer>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        // 친구 관계 조사
        for(int i=1 ; i<=M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            adj[B].add(A);
        }

        int ans = BFS(N, adj);
        System.out.println(ans);
    }

    private static int BFS(int N, List<Integer>[] adj){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] visited = new boolean[1+N];
        visited[1] = true;

        int relation = 0;    // 거리
        int cnt = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();

                for(int next : adj[node]){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                        cnt++;
                    }
                }
            }

            relation++;
            if(relation == 2) break;
        }

        return cnt;
    }

}
