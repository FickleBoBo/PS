package day_18.BOJ_P5_11438;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] adj;
    static int[] depth;
    static int[][] dp;
    static int maxLog;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 1. 주어진 입력으로 트리의 연결 관계를 나타내는 인접리스트 초기화
        adj = new ArrayList[1+N];

        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<N-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }

        // 2. LCA 알고리즘에 사용할 변수들 선언
        // maxLog : 각 노드가 가질 수 있는 최대 조상의 수(2^i번째 조상들)
        // dp : 각 노드의 부모와 조상을 저장하는 dp 테이블
        // depth : 각 노드의 깊이를 저장하는 배열
        maxLog = (int) (Math.log(N) / Math.log(2)) + 1;    // (int) Math.ceil(Math.log(N) / Math.log(2))가 좀 더 좋은듯?
        dp = new int[1+N][maxLog];
        depth = new int[1+N];

        // 3. BFS로 LCA 알고리즘에서 사용할 변수들 초기화
        // DFS로도 되고 LCA에서는 DFS가 정석이라고 함
        BFS(1);
//        DFS(1, 0);

        // 4. dp 테이블에서 조상 설정
        // 각 2^j번째 조상을 구하기 위해 1 ~ N번 노드에 대해 반복문을 돌리는 순서 중요
        for(int j=1 ; j<maxLog ; j++){
            for(int node=1 ; node<=N ; node++){
                dp[node][j] = dp[dp[node][j-1]][j-1];
            }
        }

        // 5. 두 노드에 대한 LCA 알고리즘 수행
        int M = Integer.parseInt(br.readLine());

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int ans = LCA(A, B);

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // BFS는 루트에서 수행
    private static void BFS(int root){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);

        boolean[] visited = new boolean[1+N];
        visited[root] = true;

        while(!q.isEmpty()){
            int parent = q.poll();

            for(int child : adj[parent]){
                if(visited[child]) continue;

                q.offer(child);
                visited[child] = true;

                // 각 노드의 깊이는 부모 노드의 깊이 + 1인 것을 이용
                // 기존의 BFS로 최단거리 찾는 방식도 가능
                depth[child] = depth[parent] + 1;

                // 부모 설정
                dp[child][0] = parent;
            }
        }
    }

    private static void DFS(int node, int parent){
        depth[node] = depth[parent] + 1;
        dp[node][0] = parent;

        for(int next : adj[node]){
            if(next == parent) continue;

            DFS(next, node);
        }
    }

    // LCA 알고리즘
    private static int LCA(int a, int b){
        // 깊이가 더 깊은 것을 a로 설정
        if(depth[a] < depth[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 두 노드의 깊이 차
        int diff = depth[a] - depth[b];

        // 두 노드의 깊이를 맞출때는 비트 마스킹을 이용
        // ex) 깊이 차가 5면 5 -> 101 이니까 1칸 + 4칸 이동한다 느낌
        for(int i=0 ; i<maxLog ; i++){
            if((diff & (1 << i)) > 0){
                a = dp[a][i];
            }
        }

        // 깊이 차를 맞췄는데 둘이 같은 노드면 서로 조상-자손 관계였던 것이고 둘 중 아무거나 리턴
        if (a == b) return a;

        // 깊이를 맞췄으니 이제 최소 공통 조상을 찾으면 됨
        // 방법은 최대한 멀리 건너뛰는 상황부터 가정해서 서로 조상이 다른 순간 해당 조상으로 각각 이동함
        // 종료 상황은 최소 공통 조상의 자식에 위치할 때 종료
        // ex) 6칸 위가 공통 조상일 경우
        // 8칸 위는 서로 조상이 같으니 패스(최소 공통 조상은 아니니까)
        // 4칸 위는 서로 조상이 다르니 각각 이동(이제 2칸 위가 최소 공통 조상이겠지?)
        // 2칸 위는 서로 조상이 같으니 패스(최소 공통 조상이지만 패스)
        // 1칸 위는 서로 조상이 다르니 각각 이동(이제 1칸 위가 최소 공통 조상이겠지?)
        // 반복문 종료
        for(int i=maxLog-1 ; i>=0 ; i--){
            if(dp[a][i] != dp[b][i]){
                a = dp[a][i];
                b = dp[b][i];
            }
        }

        // a 또는 b의 부모가 최소 공통 조상
        return dp[a][0];
    }

}
