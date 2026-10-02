package day_24.BOJ_S1_2468;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int maxHeight = 0;
        map = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                map[i][j] = sc.nextInt();
                maxHeight = maxHeight > map[i][j] ? maxHeight : map[i][j];
            }
        }

        int max = 0;
        for(int tc=0 ; tc<=maxHeight ; tc++){

            int cnt = 0;
            visited = new boolean[N][N];
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    if((!visited[i][j]) && (map[i][j] > tc)){
                        BFS(i, j, tc);
                        cnt++;
                    }
                }
            }

            max = max > cnt ? max : cnt;
        }

        System.out.println(max);
        sc.close();
    }

    private static void BFS(int r, int c, int height){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] item = q.poll();
            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if((nr>=0)&&(nc>=0)&&(nr<N)&&(nc<N)&&(!visited[nr][nc])&&(map[nr][nc] > height)){
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

    }

}
