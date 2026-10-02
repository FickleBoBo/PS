package day_01.BOJ_G5_12865_Fail;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	
    	int[] dp = new int[1+K];
    	
    	for(int i=0 ; i<N ; i++) {
    		dp[sc.nextInt()] = sc.nextInt();
    	}
    	
//    	for(int i=0 ; i<=K ; i++) {
//    		System.out.print(dp[i] + " ");
//    	}
//    	System.out.println();
    
    	for(int i=2 ; i<=K ; i++) {
    		for(int j=1 ; j<=i/2 ; j++) {
    			dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
    		}
    	}
    	
//    	for(int i=0 ; i<=K ; i++) {
//    		System.out.print(dp[i] + " ");
//    	}
//    	System.out.println();
//    	
    	System.out.println(dp[K]);
    	
    	sc.close();
    }
}
