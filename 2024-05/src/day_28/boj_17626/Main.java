package day_28.BOJ_S3_17626;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp = new int[225][1+N];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for(int i=1 ; i<225 ; i++){
            dp[i][0] = Integer.MAX_VALUE;
            for(int j=1 ; j<=N ; j++){
                if(j == i*i){
                    dp[i][j] = 1;
                }
                else if(j > i*i){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-i*i] + 1);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

//        for(int i=0 ; i<225 ; i++){
//            for(int j=0 ; j<=N ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[224][N]);

    }
}
