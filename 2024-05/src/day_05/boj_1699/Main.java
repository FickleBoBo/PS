package day_05.BOJ_S2_1699;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[1+N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2 ; i<=N ; i++){
            for(int j=1 ; j*j<=i ; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] + dp[j*j]);
                if(i == j*j) dp[i] = 1;
            }
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);

        sc.close();
    }
}
