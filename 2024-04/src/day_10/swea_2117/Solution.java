package day_10.SWEA_모의SW역량테스트_2117;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] map = new int[N][N];
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            int ans = 0;
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    ans = Math.max(ans, BFS(map, i, j, N, M));
                }
            }

            System.out.printf("#%d %d\n", tc, ans);

        }
        sc.close();
    }

    private static int BFS(int[][] map, int r, int c, int N, int M){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        int profit = 0;

        int cnt = 0;
        if(map[r][c]==1) cnt++;
        int size = 1;

        while(!q.isEmpty()){
            if(cnt * M - (size * size + (size-1) * (size-1)) >= 0){
                profit = Math.max(profit, cnt);
            }

            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int[] item = q.poll();
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = item[0] + dr[dir];
                    int nc = item[1] + dc[dir];
                    if((nr>=0) && (nc>=0) && (nr<N) && (nc<N) && (!visited[nr][nc])){
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        if(map[nr][nc]==1){
                            cnt++;
                        }
                    }
                }
            }
            size++;
        }
        return profit;
    }

}
