package day_06.BOJ_S3_11659;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[1+N];
        for(int i=1 ; i<=N ; i++){
            dp[i] = dp[i-1] + arr[i];
        }

        for(int i=0 ; i<M ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(dp[b]-dp[a-1]);
        }
    }
}
