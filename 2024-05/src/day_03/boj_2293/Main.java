package day_03.BOJ_G5_2293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[1+n];
        for(int i=1 ; i<=n ; i++){
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[1+n][1+k];
        for(int i=1 ; i<=n ; i++){
            dp[i][0] = 1;
            for(int j=1 ; j<=k ; j++){
                if(arr[i] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-arr[i]];
                }
            }
        }

//        for(int i=0 ; i<=n ; i++){
//            for(int j=0 ; j<=k ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n][k]);

    }
}
