package day_14.BOJ_G2_1167;

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
            return Integer.compare(o.w, this.w);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Node>[] adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=1 ; i<=N ; i++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int v = Integer.parseInt(st.nextToken());

                if(v == -1) break;

                int w = Integer.parseInt(st.nextToken());

                adj[n].add(new Node(v, w));
            }
        }

//        for(int i=1 ; i<=N ; i++){
//            System.out.println(adj[i]);
//        }

        // {가장 먼 정검, 가장 먼 거리}
        int[] result = Dijkstra(1, N, adj);
        int[] result2 = Dijkstra(result[0], N, adj);

        System.out.println(result2[1]);
    }

    private static int[] Dijkstra(int v, int N, List<Node>[] adj){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(v, 0));

        boolean[] visited = new boolean[1+N];

        int[] dist = new int[1+N];

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.v]) continue;
            visited[node.v] = true;

            for(Node next : adj[node.v]){
                if(!visited[next.v] && (dist[node.v] + next.w > dist[next.v])){
                    dist[next.v] = dist[node.v] + next.w;
//                    System.out.println(Arrays.toString(dist));
                    pq.add(new Node(next.v, next.w));
                }
            }
        }

        int ansV = 0;
        int ansDist = 0;
        for(int i=1 ; i<=N ; i++){
            if(dist[i] > ansDist){
                ansV = i;
                ansDist = dist[i];
            }
        }

//        System.out.println(Arrays.toString(dist));
//        System.out.println("ansV = " + ansV);
//        System.out.println("ansDist = " + ansDist);
        return new int[]{ansV, ansDist};
    }

}
