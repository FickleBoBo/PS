package day_18.BOJ_S4_15624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MOD = 1_000_000_007;

        int N = Integer.parseInt(br.readLine());
        if(N == 0){
            System.out.println(0);
            return;
        }

        int[] dp = new int[1+N];
        dp[1] = 1;

        for(int i=2 ; i<=N ; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}
