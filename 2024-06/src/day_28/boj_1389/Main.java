package day_28.BOJ_S1_1389;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트
        List<Integer>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1 ; i<=M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            adj[B].add(A);
        }

        int ans = -1;
        int min = Integer.MAX_VALUE;

        // 역순으로 탐색하면 케빈 베이컨의 수가 같은 사람들 중 번호가 가장 작은 사람을 바로 찾을 수 있다
        for(int i=N ; i>=1 ; i--){
            int result = BFS(i, N, adj);

            if(min >= result){
                min = result;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    private static int BFS(int A, int N, List<Integer>[] adj){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(A);

        boolean[] visited = new boolean[1+N];
        visited[A] = true;

        int dist = 0;    // 거리
        int ans = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int node = q.poll();
                ans += dist;    // 케빈 베이컨의 수 계산

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
