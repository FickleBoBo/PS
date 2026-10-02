package day_19.BOJ_S3_2606;

import java.io.*;
import java.util.*;

// 인접 리스트 방식의 BFS
public class Main_BFS2 {

    static int N;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }

        int cnt = BFS(1);
        System.out.println(cnt);
    }

    private static int BFS(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] visited = new boolean[1+N];    // 컴퓨터 번호와 index를 일치시킨 방문 체크 배열
        visited[start] = true;

        int cnt = 0;    // 1번 컴퓨터는 제외

        while(!q.isEmpty()){
            int node = q.poll();

            for(int next : adj[node]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
