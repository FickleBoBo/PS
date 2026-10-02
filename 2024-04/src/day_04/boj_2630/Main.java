package day_04.BOJ_S2_2630;

import java.util.Scanner;

public class Main {

    static int[][] map;
    static int whiteCnt = 0;
    static int blueCnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        DFS(N, 0, 0, N, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void DFS(int n, int ulr, int ulc, int drr, int drc){
        // 탈출 조건
        if(n==0) return;

//        System.out.printf("%d %d %d %d %d\n", n, ulr, ulc, drr, drc);

        if(colored(ulr, ulc, drr, drc)==-1){
            DFS(n/2, ulr, ulc, drr-n/2, drc-n/2);
            DFS(n/2, ulr, ulc+n/2, drr-n/2, drc);
            DFS(n/2, ulr+n/2, ulc, drr, drc-n/2);
            DFS(n/2, ulr+n/2, ulc+n/2, drr, drc);
        }
        else if(colored(ulr, ulc, drr, drc)==0) whiteCnt++;
        else if(colored(ulr, ulc, drr, drc)==1) blueCnt++;
    }

    private static int colored(int ulr, int ulc, int drr, int drc){
        int white = 0;
        for(int i=ulr ; i<drr ; i++){
            for(int j=ulc ; j<drc ; j++){
                if(map[i][j]==0) white++;
            }
        }

        if(white==(drr-ulr)*(drc-ulc)) return 0;

        int blue = 0;
        for(int i=ulr ; i<drr ; i++){
            for(int j=ulc ; j<drc ; j++){
                if(map[i][j]==1) blue++;
            }
        }

        if(blue==(drr-ulr)*(drc-ulc)) return 1;

        return -1;
    }

}
