package day_04.BOJ_G3_1520_Fail;

import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int M;
    static int N;
    static int[][] DP;
    static int H = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[1+M+1][1+N+1];
//        for(int i=0 ; i<M+2 ; i++){
//            Arrays.fill(map[i], Integer.MAX_VALUE);
//        }
        for(int i=1 ; i<=M ; i++){
            for(int j=1 ; j<=N ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        DP = new int[1+M+1][1+N+1];

        for(int i=1 ; i<=M ; i++){
            for(int j=1 ; j<=N ; j++){
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];
                    if(map[i][j] < map[nr][nc]) DP[i][j]++;
                }
            }
        }

        int[][] DDP = new int[1+M+1][1+N+1];

        for(int i=1 ; i<=M ; i++){
            for(int j=1 ; j<=N ; j++){
                DDP[i][j] += DP[i][j];
                for(int dir=0 ; dir<4 ; dir++){
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];
                    if(map[i][j] < map[nr][nc]) DDP[i][j] += DDP[nr][nc];
                }
            }
        }

//        DFS(1, 1);

        for(int i=1 ; i<=M ; i++){
            for(int j=1 ; j<=N ; j++){
                System.out.print(DP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for(int i=1 ; i<=M ; i++){
            for(int j=1 ; j<=N ; j++){
                System.out.print(DDP[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(H);

        sc.close();
    }

    private static void DFS(int r, int c){
        if(r==M && c==N) {
            DP[r][c]++;
            H++;
            return;
        }

        DP[r][c]++;

        for(int dir=0 ; dir<4 ; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(map[r][c] > map[nr][nc]){
                DFS(nr, nc);
            }
        }
    }

}
