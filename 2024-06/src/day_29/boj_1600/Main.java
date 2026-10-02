package day_29.BOJ_G3_1600;

import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int r;
        int c;
        int cnt;    // 말처럼 이동한 횟수

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    // 원숭이의 이동 델타 배열
    static int[] mdr = {-1, 0, 1, 0};
    static int[] mdc = {0, 1, 0, -1};

    // 말의 이동 델타 배열
    static int[] hdr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hdc = {1, 2, 2, 1, -1, -2, -2, -1};

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
        q.offer(new Node(0, 0, 0));

        // 노드의 행 위치, 노드의 열 위치, 말처럼 이동한 횟수에 대한 방문 체크 배열
        boolean[][][] visited = new boolean[H][W][1+K];
        visited[0][0][0] = true;

        int dist = 0;

        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                Node node = q.poll();
                if(node.r == H-1 && node.c == W-1) return dist;    // 종료 조건

                // 원숭이처럼 이동
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = node.r + mdr[dir];
                    int nc = node.c + mdc[dir];
                    int cnt = node.cnt;

                    if(nr>=0 && nr<H && nc>=0 && nc<W && !visited[nr][nc][cnt] && map[nr][nc]==0){
                        q.offer(new Node(nr, nc, cnt));
                        visited[nr][nc][cnt] = true;
                    }
                }

                // 말처럼 이동할 수 있는 횟수를 전부 다 쓰면 continue
                if(node.cnt == K) continue;

                // 말처럼 이동
                for(int dir=0 ; dir<8 ; dir++){
                    int nr = node.r + hdr[dir];
                    int nc = node.c + hdc[dir];
                    int cnt = node.cnt + 1;

                    if(nr>=0 && nr<H && nc>=0 && nc<W && !visited[nr][nc][cnt] && map[nr][nc]==0){
                        q.offer(new Node(nr, nc, cnt));
                        visited[nr][nc][cnt] = true;
                    }
                }

            }

            dist++;
        }

        return -1;
    }
}
