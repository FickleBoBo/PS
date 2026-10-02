package day_03.BOJ_G5_9084;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int[] arr = new int[1+N];
            for(int i=1 ; i<=N ; i++){
                arr[i] = sc.nextInt();
            }

            int M = sc.nextInt();

            int[][] dp = new int[1+N][1+M];

//            Arrays.fill(dp[0], 1);
            for(int i=1 ; i<=N ; i++){
                dp[i][0] = 1;
                for(int j=1 ; j<=M ; j++){
                    if(arr[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-arr[i]];
                    }
                }
            }

//            for(int i=0 ; i<=N ; i++){
//                for(int j=0 ; j<=M ; j++){
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }

            System.out.println(dp[N][M]);

        }

    }
}
