package day_19.BOJ_S3_2606;

import java.io.*;
import java.util.*;

// 인접 리스트 방식의 DFS
public class Main_DFS2 {

    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[1+N];    // 컴퓨터 번호와 index를 일치시킨 방문 체크 배열

        int M = Integer.parseInt(br.readLine());
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }

        int cnt = DFS(1) - 1;    // 1번 컴퓨터는 제외
        System.out.println(cnt);
    }

    private static int DFS(int node){
        visited[node] = true;    // node에 대한 방문 체크
        int cnt = 1;    // node 자신 한 개를 카운트

        for(int next : adj[node]){
            if(!visited[next]){
                cnt += DFS(next);    // 카운트에 연결된 노드의 카운트를 더한게 최종 카운트
            }
        }

        return cnt;
    }

}
