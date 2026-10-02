package day_12.BOJ_S2_1012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 0, 1, 0};    // 상 우 하 좌 델타배열
    static int[] dc = {0, 1, 0, -1};    // 상 우 하 좌 델타배열
    static int[][] map;
    static int M;
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            M = sc.nextInt();
            N = sc.nextInt();
            map = new int[N][M];

            int K = sc.nextInt();
            for(int i=0 ; i<K ; i++){
                int c = sc.nextInt();
                int r = sc.nextInt();
                map[r][c] = 1;
            }

            int ans = 0;
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<M ; j++){
                    if(map[i][j] == 1){
                        ans++;
                        BFS(i, j);    // BFS 돌리기
                    }
                }
            }

            System.out.println(ans);

        }

        sc.close();
    }

    // 배추가 심어진 곳을 발견하면 연결된 모든 배추를 파버려서 찾기(= 0으로 만듦)
    private static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});    // 좌표를 넣는 츄라이 해봄
        map[r][c] = 0;

        while(!q.isEmpty()){
            int[] pos = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = pos[0] + dr[dir];
                int nc = pos[1] + dc[dir];
                if((nr>=0) && (nc>=0) && (nr<N) && (nc<M) && (map[nr][nc] == 1)){
                    q.offer(new int[]{nr, nc});    // 연결된 배추 위치 넣기
                    map[nr][nc] = 0;               // 배추 파기
                }
            }
        }
    }

}
