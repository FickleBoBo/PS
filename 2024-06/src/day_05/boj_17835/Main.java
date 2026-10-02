package day_05.BOJ_G2_17835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Node>[] adj;
    static final long INF = 100_000_000_000L;

    static class Node implements Comparable<Node> {
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            long C = Integer.parseInt(st.nextToken());
            adj[V].add(new Node(U, C));
        }

        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            q.offer(Integer.parseInt(st.nextToken()));
        }

        long[] ans = Dijkstra(q);

        int maxIdx = 1;
        long maxValue = 0;
        for(int i=N ; i>=1 ; i--){
            if(ans[i] >= maxValue && ans[i] < INF){    // 등호가 85% 벽
                maxIdx = i;
                maxValue = ans[i];
            }
        }

//        System.out.println(Arrays.toString(ans));
        System.out.println(maxIdx);
        System.out.println(maxValue);
    }

    private static long[] Dijkstra(Queue<Integer> input){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[1+N];

        long[] dist = new long[1+N];
        Arrays.fill(dist, INF);

        while(!input.isEmpty()){
            int start = input.poll();
            pq.add(new Node(start, 0));
            dist[start] = 0;
        }

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

        return dist;
    }

}
