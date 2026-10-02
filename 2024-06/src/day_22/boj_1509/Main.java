package day_22.BOJ_G1_1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int N = input.length();

        char[] arr = new char[1+N+1];
        for(int i=1 ; i<=N ; i++){
            arr[i] = input.charAt(i-1);
        }

        int[][] dp = new int[1+N+1][1+N+1];
        for(int i=1 ; i<=N ; i++){
            dp[i][i] = 1;
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = 1;
            }
        }

        for(int i=N ; i>=1 ; i--){
            for(int j=1 ; j<=N ; j++){
                if(arr[i] == arr[j] && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                }
            }
        }

        int[] dp2 = new int[1+N];
        Arrays.fill(dp2, 1000000);
        dp2[0] = 0;

        for(int i=1 ; i<=N ; i++){
            for(int j=i ; j<=N ; j++){
                if(dp[i][j] == 1){
                    dp2[j] = Math.min(dp2[j], dp2[i-1]+1);
                }
            }
        }

//        for(int i=1 ; i<=N ; i++){
//            for(int j=1 ; j<=N ; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

//        System.out.println(Arrays.toString(dp2));

        System.out.println(dp2[N]);
    }
}
