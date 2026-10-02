package day_14.BOJ_G5_7576;

import java.io.*;
import java.util.*;

public class Main {

    // 사방탐색 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static int[][] map;

    static int tomato = 0;    // 익은 토마토의 개수
    static int empty = 0;    // 토마토가 들어있지 않은 칸의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 처음 상자에 담긴 익은 토마토를 저장하는 Queue
        Queue<int[]> tomatoQueue = new ArrayDeque<>();

        map = new int[N][M];
        for(int i=0 ; i<N ; i++){
           st = new StringTokenizer(br.readLine());
           for(int j=0 ; j<M ; j++){
               map[i][j] = Integer.parseInt(st.nextToken());

               // 익은 토마토와 빈 상자에 대한 초기화
               if(map[i][j] == 1){
                   tomato++;
                   tomatoQueue.offer(new int[]{i, j});
               }
               else if(map[i][j] == -1){
                   empty++;
               }
           }
        }

        int ans = BFS(tomatoQueue);

        if(tomato + empty == N * M){
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

                for (int dir=0 ; dir<4 ; dir++) {
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];
                    if (nr>=0 && nr<N && nc>=0 && nc<M && (map[nr][nc]==0)){
                        tomato++;
                        q.offer(new int[]{nr, nc});
                        map[nr][nc] = 1;
                    }
                }

            }

            // Queue의 길이만큼 돌면 이동 횟수가 한번 증가
            ans++;
        }

        return ans;
    }

}
