package day_01.SWEA_모의SW역량테스트_5650;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static int[][] map;
    static int N;
    static Queue<int[]> wormhole6 = new LinkedList<>();
    static Queue<int[]> wormhole7 = new LinkedList<>();
    static Queue<int[]> wormhole8 = new LinkedList<>();
    static Queue<int[]> wormhole9 = new LinkedList<>();
    static Queue<int[]> wormhole10 = new LinkedList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int ans = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            ans = 0;
            N = sc.nextInt();
            map = new int[1+N+1][1+N+1];
            for(int i=0 ; i<map.length ; i++){
                Arrays.fill(map[i], 5);
            }

            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=N ; j++){
                    map[i][j] = sc.nextInt();
                    if     (map[i][j] == 6)  wormhole6.offer(new int[]{i, j});
                    else if(map[i][j] == 7)  wormhole7.offer(new int[]{i, j});
                    else if(map[i][j] == 8)  wormhole8.offer(new int[]{i, j});
                    else if(map[i][j] == 9)  wormhole9.offer(new int[]{i, j});
                    else if(map[i][j] == 10) wormhole10.offer(new int[]{i, j});
                }
            }

            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=N ; j++){
                    if(map[i][j] == 0){
                        for(int k=0 ; k<4 ; k++){
                            int point = playPinBallGame(i, j, k);
                            ans = ans > point ? ans : point;
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, ans);

            wormhole6.clear();
            wormhole7.clear();
            wormhole8.clear();
            wormhole9.clear();
            wormhole10.clear();
        }
        sc.close();
    }

    static int playPinBallGame(int startRowPos, int startColpos, int direction) {
        int point = 0;
        int dir = direction;
        int nr = startRowPos;
        int nc = startColpos;

        while(true){

            nr += dr[dir];
            nc += dc[dir];

            if((map[nr][nc] == -1) || (nr == startRowPos) && (nc == startColpos)) break;

            else if(map[nr][nc] == 5){
                dir = (dir + 2) % 4;
                point++;
            }
            else if(map[nr][nc] == 1){
                if     (dir == 3) dir = 0;
                else if(dir == 2) dir = 1;
                else              dir = (dir + 2) % 4;
                point++;
            }
            else if(map[nr][nc] == 2){
                if     (dir == 3) dir = 2;
                else if(dir == 0) dir = 1;
                else              dir = (dir + 2) % 4;
                point++;
            }
            else if(map[nr][nc] == 3){
                if     (dir == 1) dir = 2;
                else if(dir == 0) dir = 3;
                else              dir = (dir + 2) % 4;
                point++;
            }
            else if(map[nr][nc] == 4){
                if     (dir == 1) dir = 0;
                else if(dir == 2) dir = 3;
                else              dir = (dir + 2) % 4;
                point++;
            }
            else if(map[nr][nc] > 5){
                if(map[nr][nc] == 6){
                    if((nr==wormhole6.peek()[0]) && (nc==wormhole6.peek()[1])){
                        wormhole6.offer(wormhole6.poll());
                        nr = wormhole6.peek()[0];
                        nc = wormhole6.peek()[1];
                    }
                    else{
                        nr = wormhole6.peek()[0];
                        nc = wormhole6.peek()[1];
                    }
                }
                else if(map[nr][nc] == 7){
                    if((nr==wormhole7.peek()[0]) && (nc==wormhole7.peek()[1])){
                        wormhole7.offer(wormhole7.poll());
                        nr = wormhole7.peek()[0];
                        nc = wormhole7.peek()[1];
                    }
                    else{
                        nr = wormhole7.peek()[0];
                        nc = wormhole7.peek()[1];
                    }
                }
                else if(map[nr][nc] == 8){
                    if((nr==wormhole8.peek()[0]) && (nc==wormhole8.peek()[1])){
                        wormhole8.offer(wormhole8.poll());
                        nr = wormhole8.peek()[0];
                        nc = wormhole8.peek()[1];
                    }
                    else{
                        nr = wormhole8.peek()[0];
                        nc = wormhole8.peek()[1];
                    }
                }
                else if(map[nr][nc] == 9){
                    if((nr==wormhole9.peek()[0]) && (nc==wormhole9.peek()[1])){
                        wormhole9.offer(wormhole9.poll());
                        nr = wormhole9.peek()[0];
                        nc = wormhole9.peek()[1];
                    }
                    else{
                        nr = wormhole9.peek()[0];
                        nc = wormhole9.peek()[1];
                    }
                }
                else if(map[nr][nc] == 10){
                    if((nr==wormhole10.peek()[0]) && (nc==wormhole10.peek()[1])){
                        wormhole10.offer(wormhole10.poll());
                        nr = wormhole10.peek()[0];
                        nc = wormhole10.peek()[1];
                    }
                    else{
                        nr = wormhole10.peek()[0];
                        nc = wormhole10.peek()[1];
                    }
                }
            }

        }
        return point;
    }
}
