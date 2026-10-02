package day_19.BOJ_S2_1260;

import java.io.*;
import java.util.*;

// 인접 행렬 방식
// 순회 과정에서 번호가 작은 정점부터 탐색
public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static boolean[][] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adj = new boolean[1+N][1+N];
        visited = new boolean[1+N];

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A][B] = adj[B][A] = true;    // 양방향 연결
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

        for(int i=1 ; i<=N ; i++){
            if(!visited[i] && adj[node][i]){
                DFS(i);
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

            for(int i=1 ; i<=N ; i++){
                if(!visited[i] && adj[node][i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

    }

}
