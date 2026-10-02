package day_03.BOJ_S2_11053;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];

        for(int i=0 ; i<N ; i++){
            int maxLen = 0;
            for(int j=0 ; j<=i ; j++){
                if(arr[j] < arr[i]){
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }
            dp[i] = maxLen+1;
        }

        int ans = 0;
        for(int i=0 ; i<N ; i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

    }
}
