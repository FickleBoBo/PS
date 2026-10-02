package day_20.BOJ_G4_2573_Fail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M][2];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j][0] = sc.nextInt();
            }
        }

        int time = 1;
        boolean makeTwo = false;

        out:
        while(true){
            boolean flag = meltDown();
            if(flag) break;

            visited = new boolean[N][M];
            int cnt = 0;
            for(int i=1 ; i<N-1 ; i++){
                for(int j=1 ; j<M-1 ; j++){
                    if(!visited[i][j] && map[i][j][0]>0){
                        BFS(i, j);
                        cnt++;
                        if(cnt>=2){
                            makeTwo = true;
                            break out;
                        }
                    }
                }
            }
            time++;
        }

        if(makeTwo) System.out.println(time);
        else System.out.println(0);
        sc.close();
    }

    private static boolean meltDown(){
        boolean flag = true;

        for(int i=1 ; i<N-1 ; i++){
            for(int j=1 ; j<M-1 ; j++){
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];
                    int cnt = 0;
                    if(map[nr][nc][0]==0){
                        cnt++;
                        flag = false;
                    }
                    map[nr][nc][1] = cnt;
                }
            }
        }
        for(int i=1 ; i<N-1 ; i++){
            for(int j=1 ; j<M-1 ; j++){
                map[i][j][0] -= map[i][j][1];
                map[i][j][0]  = Math.max(map[i][j][0], 0);
            }
        }
        return flag;
    }

    private static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if(!visited[nr][nc] && map[nr][nc][0]>0){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

}
