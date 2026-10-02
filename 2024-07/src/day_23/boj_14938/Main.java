package day_23.BOJ_G4_14938;

import java.io.*;
import java.util.*;

public class Main_Dijkstra {

    // 노드 클래스
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
    static int M;
    static int[] W;
    static List<Node>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 각 지역의 아이템의 개수를 저장
        W = new int[1+N];

        // 각 지역의 아이템 개수 초기화
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=N ; i++) W[i] = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++) adj[i] = new ArrayList<>();

        for(int i=0 ; i<R ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 양방향 통행
            adj[a].add(new Node(b, w));
            adj[b].add(new Node(a, w));
        }

        int ans = 0;

        // 각 지역에서 얻을 수 있는 아이템의 개수를 리턴하는 다익스트라 알고리즘
        for(int i=1 ; i<=N ; i++){
            int result = Dijkstra(i);
            ans = Math.max(ans, result);
        }

        System.out.println(ans);
    }

    private static int Dijkstra(int start){
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

        int cnt = 0;

        // 해당 지역에서 갈 수 있는 지역의 아이템을 모두 찾음
        for(int i=1 ; i<=N ; i++){
            if(dist[i] <= M){
                cnt += W[i];
            }
        }

        return cnt;
    }

}
