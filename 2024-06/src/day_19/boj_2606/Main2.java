package day_19.BOJ_S3_2606;

import java.io.*;
import java.util.StringTokenizer;

// 인접 행렬 방식의 DFS
public class Main_DFS1 {

    static int N;
    static boolean[][] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new boolean[1+N][1+N];    // 연결이 됐다, 안됐다 두 가지 상태만 있으므로 boolean[][] 타입으로 선언
        visited = new boolean[1+N];    // 컴퓨터 번호와 index를 일치시킨 방문 체크 배열

        int M = Integer.parseInt(br.readLine());
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A][B] = adj[B][A] = true;    // 양방향 연결
        }

        int cnt = DFS(1) - 1;    // 1번 컴퓨터는 제외
        System.out.println(cnt);
    }

    private static int DFS(int node){
        visited[node] = true;    // node에 대한 방문 체크
        int cnt = 1;    // node 자신 한 개를 카운트

        for(int i=1 ; i<=N ; i++){
            if(!visited[i] && adj[node][i]){
                cnt += DFS(i);    // 카운트에 연결된 노드의 카운트를 더한게 최종 카운트
            }
        }

        return cnt;
    }

}
