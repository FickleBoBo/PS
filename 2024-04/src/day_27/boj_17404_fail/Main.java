package day_27.BOJ_G4_17404_Fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[1+N][3];
        for(int i=1 ; i<=N ; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        int[][] dp = new int[1+N][3];
        dp[1][0] = Math.min(arr[N][1], arr[N][2]) + arr[1][0];
        dp[1][1] = Math.min(arr[N][0], arr[N][2]) + arr[1][1];
        dp[1][2] = Math.min(arr[N][0], arr[N][1]) + arr[1][2];
        for(int i=2 ; i<N ; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

//        for(int i=0 ; i<dp.length ; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        int ans = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(ans);

        sc.close();
    }
}
