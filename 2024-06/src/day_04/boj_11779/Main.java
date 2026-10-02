package day_04.BOJ_G3_11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 1000000000;
    static int N;
    static List<Node>[] adj;

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
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList[1+N];
        for(int i=1 ; i<=N ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adj[A].add(new Node(B, C));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[][] ans = Dijkstra(start);
//        for(int i=0 ; i<2 ; i++){
//            for(int j=1 ; j<=N ; j++){
//                System.out.print(ans[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(ans[0][end]);

        Stack<Integer> stack = new Stack<>();
        while(true){
            stack.push(end);
            end = ans[1][end];
            if(end == 0) break;
        }

        System.out.println(stack.size());
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }

    private static int[][] Dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        boolean[] visited = new boolean[1+N];

        int[][] dp = new int[2][1+N];
        Arrays.fill(dp[0], INF);
        dp[0][start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.v]) continue;
            visited[node.v] = true;

            for(Node next : adj[node.v]){
                if(!visited[next.v] && (dp[0][node.v] + next.w < dp[0][next.v])){
                    dp[0][next.v] = dp[0][node.v] + next.w;
                    pq.add(new Node(next.v, dp[0][next.v]));
                    dp[1][next.v] = node.v;
                }
            }

//            for(int i=0 ; i<2 ; i++){
//                for(int j=1 ; j<=N ; j++){
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        return dp;
    }

}
