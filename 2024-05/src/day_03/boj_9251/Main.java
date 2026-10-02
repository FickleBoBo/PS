package day_03.BOJ_G5_9251;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int N = str1.length();
        int M = str2.length();

        int[][] dp = new int[1+N][1+M];
        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=M ; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] + 1);
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

//        for(int i=1 ; i<=N ; i++){
//            for(int j=1 ; j<=M ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N][M]);
    }
}
