package day_24.BOJ_S1_1926;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        int max = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(map[i][j] == 1){
                    int result = BFS(i, j);
                    max = max > result ? max : result;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
        sc.close();
    }

    private static int BFS(int r, int c){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        cnt++;
        map[r][c] = 0;

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if((nr>=0)&&(nc>=0)&&(nr<n)&&(nc<m)&&(map[nr][nc]==1)){
                    q.offer(new int[]{nr, nc});
                    cnt++;
                    map[nr][nc] = 0;
                }
            }
        }
        return cnt;
    }

}
