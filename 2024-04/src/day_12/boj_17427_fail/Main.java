package day_12.BOJ_S2_17427_Fail;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[1+N];
		
		for(int num=1 ; num<=N ; num++) {
			if(num % 2 == 0) {
				dp[num] = dp[num/2] + num;
			}
			else {
				for(int i=1 ; i<=num ; i++) {
					if(num % i == 0) {
						dp[num] += i;
					}
				}
			}
//			dp[num] += dp[num-1];
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
		sc.close();
	}
}
