package day_21.BOJ_G2_2211_Fail;

import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int st, ed, v;

        public Node(int st, int ed, int v) {
            this.st = st;
            this.ed = ed;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.v, o.v);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Node>[] nodes = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            nodes[i] = new ArrayList<>();
        }
        for(int i=0 ; i<M ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();
            nodes[x].add(new Node(x, y, v));
            nodes[y].add(new Node(y, x, v));
        }

        List<Node> ans = Dijkstra(N, nodes, 1);

        System.out.println(ans.size());
        for(Node node : ans){
            System.out.println(node.st + " " + node.ed);
        }
        sc.close();
    }

    private static List<Node> Dijkstra(int N, List<Node>[] nodes, int start){
        List<Node> ans = new LinkedList<>();

        int[] dist = new int[1+N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.addAll(nodes[start]);

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(dist[node.ed] < node.v) continue;

            ans.add(node);
            dist[node.ed] = node.v;

            for(Node next : nodes[node.ed]){
                if(dist[node.ed]+node.v < dist[next.ed]){
                    pq.offer(new Node(next.st, next.ed, dist[node.ed]+node.v));
                }
            }
        }

        return ans;
    }

}
