package day_08.BOJ_G3_2533;

import java.io.*;
import java.util.*;

// 메모리 40만 KB에 시간 1800ms 대라 베스트 풀이가 아닌듯
public class Main {

    static List<Integer>[] adj;
    static boolean[] visited;
    static boolean[] dp;    // 얼리어답터면 true, 아니면 false
    static int cnt = 0;    // 얼리어답터의 수

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
        dp = new boolean[1+N];

        // 어떤 노드에서 시작해도 상관 없음? (트리는 루트가 고정이 아닌가?)
        int start = 1;
        visited[start] = true;

        DFS(start);

        System.out.println(cnt);
    }

    private static void DFS(int node){
        // 리프 노드면 바로 리턴(얼리어답터가 아니게 해야 최소)
        if(adj[node].isEmpty()) return;

        // 기본은 DFS 재귀 구조인데 연결된 자식 노드가 얼리어답터가 아니면 부모는 무조건 얼리어답터임
        for(int next : adj[node]){
            if(!visited[next]){
                visited[next] = true;
                DFS(next);

                // 얼리어답터가 아닌 자식이 있으면서 부모가 얼리어답터 판정이 안됐으면,
                // 부모를 얼리어답터로 만들고 개수 세기
                if(!dp[node] && !dp[next]){
                    dp[node] = true;
                    cnt++;
                }
            }
        }
    }

}
