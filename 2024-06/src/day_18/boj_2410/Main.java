package day_18.BOJ_G5_2410;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int row = 1;
        int value = 1;
        while(value <= N){
            value *= 2;
            row++;
        }
        row--;

        int[][] dp = new int[row][1+N];
        Arrays.fill(dp[0], 1);

        for(int i=1 ; i<row ; i++){
            dp[i][0] = 1;
            for(int j=1 ; j<=N ; j++){
                if(j >= (int) Math.pow(2, i)){
                    dp[i][j] = (dp[i-1][j] + dp[i][j - (int) Math.pow(2, i)]) % 1000000000;
                }
                else{
                    dp[i][j] = dp[i-1][j] % 1000000000;
                }
            }
        }

//        for(int i=0 ; i<=N ; i++){
//            System.out.printf("%4d", i);
//        }
//        System.out.println();
//        System.out.println();
//
//        for(int i=0 ; i<row ; i++){
//            System.out.printf("%4d", (int) Math.pow(2, i));
//            for(int j=1 ; j<=N ; j++){
//                System.out.printf("%4d", dp[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(dp[row-1][N] % 1000000000);
    }
}
