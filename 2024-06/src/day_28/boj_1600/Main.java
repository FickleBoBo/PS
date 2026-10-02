package day_28.BOJ_G3_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] drh = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dch = {1, 2, 2, 1, -1, -2, -2, -1};

    static int H;
    static int W;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for(int i=0 ; i<H ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0 ; j<W ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = BFS(K);
        System.out.println(ans);
    }

    private static int BFS(int K){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, K));

        int[][] visited = new int[H][W];
        for(int i=0 ; i<H ; i++){
            Arrays.fill(visited[i], -1);
        }
        visited[0][0] = K;

        int dist = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                Node node = q.poll();
                if(node.r == H-1 && node.c == W-1) return dist;

                for(int dir=0 ; dir<4 ; dir++){
                    int nr = node.r + dr[dir];
                    int nc = node.c + dc[dir];

                    if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]==0){
                        if(visited[nr][nc] < node.cnt){
                            q.offer(new Node(nr, nc, node.cnt));
                            visited[nr][nc] = node.cnt;
                        }
                    }
                }

                if(node.cnt == 0) continue;

                for(int dir=0 ; dir<8 ; dir++){
                    int nr = node.r + drh[dir];
                    int nc = node.c + dch[dir];

                    if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]==0){
                        // if(visited[nr][nc] < node.cnt) 이건 메모리 초과
                        if(visited[nr][nc] < node.cnt-1){
                            q.offer(new Node(nr, nc, node.cnt-1));
                            visited[nr][nc] = node.cnt-1;
                        }
                    }
                }

//                for(int k=0 ; k<H ; k++){
//                    for(int j=0 ; j<W ; j++){
//                        System.out.print(visited[k][j] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }

            dist++;
        }

        return -1;
    }

}
