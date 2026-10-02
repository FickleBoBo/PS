package day_30.BOJ_B2_2747;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1+n];
        dp[1] = 1;
        for(int i=2 ; i<=n ; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
        sc.close();
    }
}
