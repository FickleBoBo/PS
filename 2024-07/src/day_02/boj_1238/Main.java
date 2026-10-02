package day_02.BOJ_G3_1238;

import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static final int INF = 1_000_000_000;
    static int N;

    static List<Node>[] adj;
    static List<Node>[] reverseAdj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // adj : 정방향 인접 리스트
        // reverseAdj : 간선 방향을 반대로한 연결 리스트
        adj = new ArrayList[1+N];
        reverseAdj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++) adj[i] = new ArrayList<>();
        for(int i=1 ; i<=N ; i++) reverseAdj[i] = new ArrayList<>();

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            adj[A].add(new Node(B, T));
            reverseAdj[B].add(new Node(A, T));
        }

        int[] dp1 = Dijkstra(X, adj);    // X에서 다른 모든 도시까지 가는 최단 거리 배열을 반환
        int[] dp2 = Dijkstra(X, reverseAdj);    // 다른 모든 도시에서 X까지 가는 최단 거리 배열을 반환

        int max = Integer.MIN_VALUE;
        for(int i=1 ; i<=N ; i++){
            max = Math.max(max, dp1[i] + dp2[i]);
        }

        System.out.println(max);
    }

    // 일반 다익스트라 알고리즘
    private static int[] Dijkstra(int start, List<Node>[] adj){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[1+N];

        int[] dist = new int[1+N];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.v]) continue;
            visited[node.v] = true;

            for(Node next : adj[node.v]){
                if(!visited[next.v] && (dist[next.v] > dist[node.v] + next.w)){
                    dist[next.v] = dist[node.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

}
