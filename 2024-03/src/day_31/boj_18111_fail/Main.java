package day_31.boj_18111_fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int B = sc.nextInt();

        int sum = B;
        int min = 0;
        int max = 0;
        int[][] map = new int[N][M];
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j] = sc.nextInt();
                sum += map[i][j];
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        double avg = (double) sum / (N * M);

        sc.close();
    }
}
