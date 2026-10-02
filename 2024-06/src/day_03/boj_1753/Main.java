package day_03.BOJ_G4_1753;

import java.io.*;
import java.util.*;

public class Main {

    static int V;
    static List<Node>[] adj;
    static final int INF = Integer.MAX_VALUE;

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        adj = new ArrayList[1+V];
        for(int i=1 ; i<=V ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<E ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w));
        }

        int[] ans = dijkstra(K);
        for(int i=1 ; i<=V ; i++){
            if(ans[i] == INF){
                bw.write("INF\n");
            }
            else{
                bw.write(ans[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static int[] dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[1+V];
        int[] dist = new int[1+V];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.v]) continue;
            visited[node.v] = true;

            for(Node next : adj[node.v]){
                if(!visited[next.v] && dist[node.v] + next.w < dist[next.v]){
                    dist[next.v] = dist[node.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

}
