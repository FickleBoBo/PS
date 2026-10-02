package day_03.BOJ_S2_11051;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[1+N][1+K];
        dp[0][0] = 1;
        for(int i=1 ; i<=N ; i++){
            dp[i][0] = 1;
            for(int j=1 ; j<=K ; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }

//        for(int i=0 ; i<=N ; i++){
//            for(int j=0 ; j<=K ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[N][K]);
    }
}
