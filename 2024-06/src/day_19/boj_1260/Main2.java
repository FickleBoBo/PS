package day_19.BOJ_S2_1260;

import java.io.*;
import java.util.*;

// 인접 리스트 방식
// 각각의 리스트에 대해 정렬을 해줘야 번호가 작은 정점부터 탐색
public class Main2 {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[1+N];

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }

        // 인접 리스트 정렬
        for(int i=1 ; i<=N ; i++){
            Collections.sort(adj[i]);
        }

        DFS(V);
        sb.append("\n");
        BFS(V);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void DFS(int node){
        visited[node] = true;    // node에 대한 방문 체크
        sb.append(node).append(" ");

        for(int next : adj[node]){
            if(!visited[next]){
                DFS(next);
            }
        }
    }

    private static void BFS(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        visited = new boolean[1+N];
        visited[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            sb.append(node).append(" ");

            for(int next : adj[node]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }

    }

}
