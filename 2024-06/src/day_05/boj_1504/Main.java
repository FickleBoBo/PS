package day_05.BOJ_G4_1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Node>[] adj;
    static final int INF = 700000000;

    static class Node implements Comparable<Node> {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<E ; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adj[A].add(new Node(B, C));
            adj[B].add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans = Math.min(Dijkstra(1, v1) + Dijkstra(v1, v2) + Dijkstra(v2, N), Dijkstra(1, v2) + Dijkstra(v2, v1) + Dijkstra(v1, N));
        if(ans >= INF){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }

    private static int Dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        boolean[] visited = new boolean[1+N];

        int[] dist = new int[1+N];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.v]) continue;
            visited[node.v] = true;

            for(Node next : adj[node.v]){
                if(!visited[next.v] && (dist[node.v] + next.w < dist[next.v])){
                    dist[next.v] = dist[node.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist[end];
    }

}
