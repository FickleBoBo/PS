package day_14.BOJ_G5_7569;

import java.io.*;
import java.util.*;

public class Main {

    // 육방탐색 델타배열
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};

    static int N;
    static int M;
    static int H;
    static int[][][] map;

    static int tomato = 0;    // 익은 토마토의 개수
    static int empty = 0;    // 토마토가 들어있지 않은 칸의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 처음 상자에 담긴 익은 토마토를 저장하는 Queue
        Queue<int[]> tomatoQueue = new ArrayDeque<>();

        map = new int[H][N][M];
        for(int k=0 ; k<H ; k++){
            for(int i=0 ; i<N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0 ; j<M ; j++){
                    map[k][i][j] = Integer.parseInt(st.nextToken());

                    // 익은 토마토와 빈 상자에 대한 초기화
                    if(map[k][i][j] == 1){
                        tomato++;
                        tomatoQueue.offer(new int[]{k, i, j});
                    }
                    else if(map[k][i][j] == -1){
                        empty++;
                    }
                }
            }
        }

        int ans = BFS(tomatoQueue);

        if(tomato + empty == N * M * H){
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }
    }

    // 토마토를 모두 익히는데 걸리는 최소 날짜
    private static int BFS(Queue<int[]> defaultTomato){

        // 처음 상자에 담겨 있었던 익은 토마토를 Queue에 넣어줌
        Queue<int[]> q = new ArrayDeque<>(defaultTomato);

        // 처음 큐에 담긴 익은 토마토가 0일에 해당하므로 -1로 초기화 해줌
        int ans = -1;

        while (!q.isEmpty()) {
            int len = q.size();

            // BFS로 최단거리를 구하는 방법
            for (int i=0 ; i<len ; i++) {
                int[] node = q.poll();

                for (int dir=0 ; dir<6 ; dir++) {
                    int nh = node[0] + dh[dir];
                    int nr = node[1] + dr[dir];
                    int nc = node[2] + dc[dir];
                    if (nh>=0 && nh<H && nr>=0 && nr<N && nc>=0 && nc<M && (map[nh][nr][nc]==0)){
                        tomato++;
                        q.offer(new int[]{nh, nr, nc});
                        map[nh][nr][nc] = 1;
                    }
                }

            }

            // Queue의 길이만큼 돌면 이동 횟수가 한번 증가
            ans++;
        }

        return ans;
    }

}
