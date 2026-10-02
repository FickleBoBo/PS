package day_29.BOJ_S2_15988;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            long[] dp = new long[1+N];

            if(N==1) System.out.println(1);
            else if(N==2) System.out.println(2);
            else if(N==3) System.out.println(4);
            else{
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;
                for(int i=4 ; i<=N ; i++){
                    dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1_000_000_009;
                }
                System.out.println(dp[N]);
            }
        }
        sc.close();
    }
}
