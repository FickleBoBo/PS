package day_28.BOJ_G1_1208_Fail;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int[][] dp = new int[1+N][1+N];
        for(int i=1 ; i<=N ; i++){
            for(int j=i ; j<=N ; j++){
                dp[i][j] = dp[i][j-1] + arr[j-1];
            }
        }



        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                System.out.printf("%3d ", dp[i][j]);
            }
            System.out.println();
        }

        int cnt = 0;
        System.out.println(cnt);
        sc.close();
    }

}
