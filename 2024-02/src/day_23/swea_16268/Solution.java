package day_23.SWEA_D2_16268;

import java.util.Scanner;

public class Solution {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[1+N+1][1+M+1];
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=M ; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=M ; j++){
                    int tmp = map[i][j];
                    for(int k=0 ; k<4 ; k++){
                        tmp += map[i+dr[k]][j+dc[k]];
                    }
                    max = Math.max(max, tmp);
                }
            }
            System.out.printf("#%d %d\n", tc, max);
        }
        sc.close();
    }
}
