package day_19.BOJ_S2_11725;

import java.io.*;
import java.util.*;

public class Main_BFS {

    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] p;    // 각 노드의 부모 노드를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[1+N];
        p = new int[1+N];

        for(int i=0 ; i<N-1 ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }

        BFS(1);
        for(int i=2 ; i<=N ; i++){
            sb.append(p[i]).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void BFS(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        visited = new boolean[1+N];
        visited[start] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int next : adj[node]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    p[next] = node;    // node와 연결된 next들의 부모 초기화
                }
            }
        }

    }

}
