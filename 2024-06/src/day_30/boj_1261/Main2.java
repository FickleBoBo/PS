package day_30.BOJ_G4_1261;

import java.io.*;
import java.util.*;

public class Main_Dijkstra {

    static class Node implements Comparable<Node>{
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static final int INF = 1_000_000_000;
    static int N;
    static int M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0 ; i<N ; i++){
            map[i] = br.readLine().toCharArray();
        }

        int ans = Dijkstra();
        System.out.println(ans);
    }

    // 다익스트라 알고리즘
    private static int Dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        // 방문 체크 배열
        boolean[][] visited = new boolean[N][M];

        // 해당 위치에 가기 위해 벽을 부순 횟수를 저장하는 배열
        int[][] dist = new int[N][M];
        for(int i=0 ; i<N ; i++){
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.r][node.c]) continue;
            visited[node.r][node.c] = true;

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];

                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]){
                    // 빈칸이면서 벽을 덜 부수고 갈 수 있으면
                    if(map[nr][nc]=='0'){
                        if(dist[nr][nc] > dist[node.r][node.c]){
                            dist[nr][nc] = dist[node.r][node.c];
                            pq.offer(new Node(nr, nc, dist[nr][nc]));
                        }
                    }
                    // 벽이면서 벽을 덜 부수고 갈 수 있으면
                    else{
                        if(dist[nr][nc] > dist[node.r][node.c] + 1){
                            dist[nr][nc] = dist[node.r][node.c] + 1;
                            pq.offer(new Node(nr, nc, dist[nr][nc]));
                        }
                    }
                }
            }
        }

        return dist[N-1][M-1];
    }

}
