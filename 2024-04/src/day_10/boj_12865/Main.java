package day_10.BOJ_G5_12865;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] object = new int[1+N][2];
        for(int i=1 ; i<=N ; i++){
            object[i][0] = sc.nextInt();
            object[i][1] = sc.nextInt();
        }

        int[][] dp = new int[1+N][1+K];
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=K ; j++){
                if(j >= object[i][0]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-object[i][0]]+object[i][1]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

//        for(int i=1 ; i<dp.length ; i++){
//            for(int j=1 ; j<dp[i].length ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N][K]);

        sc.close();
    }
}
