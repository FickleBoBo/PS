package day_30.BOJ_G4_1261;

import java.io.*;
import java.util.*;

public class Main_BFS {

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

    static final int INF = Integer.MAX_VALUE;
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

        int ans = BFS();
        System.out.println(ans);
    }

    private static int BFS(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        int[][] visited = new int[N][M];
        for(int i=0 ; i<N ; i++){
            Arrays.fill(visited[i], INF);
        }
        visited[0][0] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if((node.r==N-1) && (node.c==M-1)) return node.cnt;    // 한번이라도 갱신되면 그게 최솟값

            for(int dir=0 ; dir<4 ; dir++){
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];
                int cnt = node.cnt;

                if(nr>=0 && nr<N && nc>=0 && nc<M){
                    if(map[nr][nc]=='0'){
                        if(visited[nr][nc] > cnt){
                            pq.offer(new Node(nr, nc, cnt));
                            visited[nr][nc] = cnt;
                        }
                    }
                    else{
                        if(visited[nr][nc] > cnt+1){
                            pq.offer(new Node(nr, nc, cnt+1));
                            visited[nr][nc] = cnt+1;
                        }
                    }
                }
            }
        }

        return -1;
    }

}
