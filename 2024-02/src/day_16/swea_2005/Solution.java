package day_16.SWEA_D2_2005;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int[][] arr = new int[N+1][N+1];

            arr[0][0] = 1;
            for(int i=1 ; i<=N ; i++) {
                for (int j=1; j<=i; j++) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }

            System.out.printf("#%d\n", tc);
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=i ; j++){
                    System.out.printf("%d ", arr[i][j]);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
