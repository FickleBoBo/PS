package day_23.BOJ_S2_4963;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static int w;
    static int h;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            w = sc.nextInt();
            h = sc.nextInt();

            if((w==0) && (h==0)) break;

            map = new int[1+h+1][1+w+1];
            for(int i=1 ; i<=h ; i++){
                for(int j=1 ; j<=w ; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            int ans = 0;

            for(int i=1 ; i<=h ; i++){
                for(int j=1 ; j<=w ; j++){
                    if(map[i][j] == 1){
                        BFS(i, j);
                        ans++;
                    }
                }
            }

            System.out.println(ans);

        }
        sc.close();
    }

    static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<8 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if(map[nr][nc] == 1){
                    map[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
