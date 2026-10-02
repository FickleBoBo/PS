package day_29.BOJ_S3_1463_Fail;

import java.util.Scanner;

public class Main {

    static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        dp = new int[1+X];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        int i=0;
        while((i*3!=X) || (i*2!=X) || (i+1!=X)){
            if(dp[i] != 0){
                dp[i*3] = dp[i]+1;
                dp[i*2] = dp[i]+1;
                dp[i+1] = dp[i]+1;
            }
            i++;
        }

        System.out.println(dp[X]);
        sc.close();
    }
}
