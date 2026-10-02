package day_26.BOJ_G5_14503_Fail;

import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 0, 1, 0};    // 상 우 하 좌
    static int[] dc = {0, 1, 0, -1};    // 상 우 하 좌

    static int fourWaySearch(int[][] arr, int r, int c, int d){
        for(int i=0 ; i<4 ; i++){
            if(arr[r+dr[d]][c+dc[d]] == 0){
                return d;
            }
            d = (d + 3) % 4;
        }
        return -1;
    }

    static void printRoom(int[][] arr){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int[][] room = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                room[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        while((r!=0) && (c!=0) && (r!=N-1) && (c!=M-1)){





        }

        System.out.println(cnt);

        sc.close();
    }
}
