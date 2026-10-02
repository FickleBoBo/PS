package day_16.BOJ_G2_1368_Fail;

import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w) {this.v = v; this.w = w;}

        @Override
        public int compareTo(Node o) {return this.w - o.w;}
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        int[] W = new int[V];
        for(int i=0 ; i<V ; i++){
            W[i] = sc.nextInt();
        }

        List<Node>[] adj = new ArrayList[V];
        for(int i=0 ; i<V ; i++){
            adj[i] = new ArrayList<>();
            for(int j=0 ; j<V ; j++){
                Node input = new Node(j, sc.nextInt());
                if(i!=j){
                    adj[i].add(input);
                }
            }
        }

        int ans = 0;
        int cnt = 0;

        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        while(cnt < V){
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int i=0 ; i<V ; i++){
                if(W[i] < min){
                    min = W[i];
                    idx = i;
                }
            }

            for(Node next : adj[idx]){
                if(dist[next.v] > next.w){
                    dist[next.v] = next.w;
                }
            }

            W[idx] = Integer.MAX_VALUE;
            dist[idx] = 0;

            ans += min;
            cnt++;
            pq.addAll(adj[idx]);

//            System.out.println(Arrays.toString(W));
//            System.out.println(Arrays.toString(dist));
//            System.out.println();

            while(!pq.isEmpty()){
                Node curr = pq.poll();

                if(visited[curr.v]) continue;

                visited[curr.v] = true;

                for(Node next : adj[curr.v]){
                    if(dist[next.v] > next.w){
                        dist[next.v] = next.w;
                    }
                }

//                System.out.println(Arrays.toString(dist));
//                System.out.println();

                if(W[curr.v] > dist[curr.v]){
                    ans += dist[curr.v];
                    cnt++;
                    pq.addAll(adj[curr.v]);
                }

            }
        }
//        System.out.println(Arrays.toString(W));
//        System.out.println(Arrays.toString(visited));
//        System.out.println(Arrays.toString(dist));
        System.out.println(ans);

        sc.close();
    }
}
