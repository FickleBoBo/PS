package day_25.BOJ_G4_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int w;

        public Node(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int[][] adj = new int[N][N];
            for(int i=0 ; i<N ; i++){
                st = new StringTokenizer(br.readLine());

                for(int j=0 ; j<N ; j++){
                    adj[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int dist = Dijkstra(N, adj);

            System.out.println("Problem " + tc++ + ": " + dist);
        }

    }

    private static int Dijkstra(int N, int[][] adj){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        boolean[][] visited = new boolean[N][N];

        int[][] dist = new int[N][N];
        for(int i=0 ; i<N ; i++){
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = adj[0][0];

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.r][node.c]) continue;
            visited[node.r][node.c] = true;

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];
                
                if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]){
                    
                    // 등호 있으나 없으나네
                    if(dist[node.r][node.c] + adj[nr][nc] <= dist[nr][nc]){
                        dist[nr][nc] = dist[node.r][node.c] + adj[nr][nc];
                        pq.add(new Node(nr, nc, dist[nr][nc]));
                    }
                }

            }
        }

//        for(int i=0 ; i<N ; i++){
//            for(int j=0 ; j<N ; j++){
//                System.out.printf("%20d", dist[i][j]);
//            }
//            System.out.println();
//        }

        return dist[N-1][N-1];
    }

}
