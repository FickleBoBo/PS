package day_24.BOJ_S1_2583;

import java.util.*;

public class Main {

    static int M;
    static int N;
    static int K;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[M][N];
        for(int i=0 ; i<K ; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int j=y1 ; j<y2 ; j++){
                for(int k=x1 ; k<x2 ; k++){
                    map[j][k] = 1;
                }
            }
        }

        List<Integer> ansList = new LinkedList<>();
        for(int i=0 ; i<M ; i++){
            for(int j=0 ; j<N ; j++){
                if(map[i][j] == 0){
                    ansList.add(BFS(i, j));
                }
            }
        }

        Collections.sort(ansList);

        System.out.println(ansList.size());
        for(int area : ansList){
            System.out.print(area + " ");
        }

    }

    private static int BFS(int r, int c) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        map[r][c] = 1;
        cnt++;

        while(!q.isEmpty()){
            int[] item = q.poll();

            for(int dir=0 ; dir<4 ; dir++){
                int nr = item[0] + dr[dir];
                int nc = item[1] + dc[dir];
                if((nr>=0)&&(nc>=0)&&(nr<M)&&(nc<N)&&(map[nr][nc]==0)){
                    q.offer(new int[]{nr, nc});
                    map[nr][nc] = 1;
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
