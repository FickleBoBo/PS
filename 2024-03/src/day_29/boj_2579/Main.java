package day_29.BOJ_S3_2579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            arr[i] = sc.nextInt();
        }

        if(N == 1){
            System.out.println(arr[1]);
        }
        else{
            int[] dp = new int[1+N];
            dp[1] = arr[1];
            dp[2] = dp[1] + arr[2];
            for(int i=3 ; i<=N ; i++){
                dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2]) + arr[i];
            }

            System.out.println(dp[N]);
        }

        sc.close();
    }

}
