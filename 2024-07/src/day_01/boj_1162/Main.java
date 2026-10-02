package day_01.BOJ_P5_1162;

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int v;    // 해당 노드 번호
        long w;    // 해당 노드까지의 가중치
        int cnt;    // 해당 노드까지의 도로 포장 횟수

        public Node(int v, long w, int cnt) {
            this.v = v;
            this.w = w;
            this.cnt = cnt;
        }

        // 테스트 케이스 3% - 정렬 기준은 간선 가중치 합(처음엔 포장 횟수로 했었음)
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }

    static final long INF = 1_000_000_000_000L;
    static int N;
    static int M;
    static int K;

    static List<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            // 양방향 연결
            adj[A].add(new Node(B, W, 0));
            adj[B].add(new Node(A, W, 0));
        }

        // 테스트 케이스 63% - 경로와 관련된 변수는 long형으로 해야함(int형 오버플로우)
        long ans = Dijkstra();
        System.out.println(ans);
    }

    private static long Dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));

        // 행은 도시 번호, 열은 포장 횟수에 대한 방문 체크 배열
        boolean[][] visited = new boolean[1+N][1+K];

        // 행은 도시 번호, 열은 포장 횟수에 대한 최단 거리 배열
        long[][] dist = new long[1+N][1+K];
        for(int i=1 ; i<=N ; i++){
            Arrays.fill(dist[i], INF);
        }
        dist[1][0] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            // 도시 번호와 포장 횟수가 일치하는 경로를 방문했는지 체크(같은 도시를 다른 포장 횟수로 방문했으면 다른 경로임)
            if(visited[node.v][node.cnt]) continue;
            visited[node.v][node.cnt] = true;

            for(Node next : adj[node.v]){
                // 포장을 하지 않고 다음 도시를 선택하는 상황
                // 포장을 안했으니 시간은 더하고 포장 횟수는 그대로
                if(!visited[next.v][node.cnt] && (dist[next.v][node.cnt] > dist[node.v][node.cnt] + next.w)){
                    dist[next.v][node.cnt] = dist[node.v][node.cnt] + next.w;
                    pq.offer(new Node(next.v, dist[next.v][node.cnt], node.cnt));
                }
                // 포장을 하고 다음 도시를 선택하는 상황
                // 포장을 했으니 포장 횟수는 더하고 시간은 그대로
                if(node.cnt < K && !visited[next.v][node.cnt+1] && (dist[next.v][node.cnt+1] > dist[node.v][node.cnt])){
                    dist[next.v][node.cnt+1] = dist[node.v][node.cnt];
                    pq.offer(new Node(next.v, dist[next.v][node.cnt+1], node.cnt+1));
                }
            }
        }

        // 테스트 케이스 83% - 도로를 정확히 K번 포장할 경우가 최단경로가 아닐 수 있어서 dist[N][K]를 리턴하면 안됨
        long ans = INF;

        for(int i=0 ; i<=K ; i++){
            ans = Math.min(ans, dist[N][i]);
        }
        return ans;
    }

}
