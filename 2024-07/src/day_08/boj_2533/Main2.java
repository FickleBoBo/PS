package day_08.BOJ_G3_2533;

import java.io.*;
import java.util.*;

// 풀이 찾아봤는데 메모리 40만 KB에 시간 1800ms 대라 이것도 그저그런듯
public class Main2 {

    static List<Integer>[] adj;
    static boolean[] visited;

    // dp[n][0]은 n번 노드가 얼리어답터일때, 얼리어답터의 수
    // dp[n][1]은 n번 노드가 얼리어답터가 아닐때, 얼리어답터의 수
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++) adj[i] = new ArrayList<>();

        for(int i=0 ; i<N-1 ; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        visited = new boolean[1+N];
        dp = new int[1+N][2];

        // 어떤 노드에서 시작해도 상관 없음? (트리는 루트가 고정이 아닌가?)
        int start = 1;
        DFS(start);

        // start번 노드가 얼리어답터일때와 아닐때 중 최소값
        System.out.println(Math.min(dp[start][0], dp[start][1]));
    }

    private static void DFS(int node){
        visited[node] = true;

        // node가 얼리어답터면 개수 1
        dp[node][0] = 1;

        for(int next : adj[node]){
            if(visited[next]) continue;
            DFS(next);

            // node가 얼리어답터일 경우, 자식들은 얼리어답터거나 얼리어답터가 아니거나 가능
            dp[node][0] += Math.min(dp[next][0], dp[next][1]);

            // node가 얼리어답터가 아닐 경우, 자식들은 전부 얼리어답터여야 함
            dp[node][1] += dp[next][0];
        }

    }

}
