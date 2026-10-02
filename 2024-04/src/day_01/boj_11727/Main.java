package day_01.BOJ_S3_11727;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1+n];
        if(n==1){
            dp[1] = 1;
        }
        else{
            dp[1] = 1;
            dp[2] = 3;
            for(int i=3 ; i<=n ; i++){
                dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
            }
        }

        System.out.println(dp[n]);

        sc.close();
    }
}
