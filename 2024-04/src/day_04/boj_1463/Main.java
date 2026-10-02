package day_04.BOJ_S3_1463;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		
		int[] DP = new int[1+N];
		
		for(int i=2 ; i<=N ; i++) {
			// 6으로 먼저 나눠야하는데 아마 else에서 대충 해서 그런듯? 모름
			if(i%6==0) DP[i] = Math.min(DP[i-1], Math.min(DP[i/3], DP[i/2])) + 1;
			else if(i%3==0) DP[i] = Math.min(DP[i/3], DP[i-1]) + 1;
			else if(i%2==0) DP[i] = Math.min(DP[i/2], DP[i-1]) + 1;
			else DP[i] = DP[i-1] + 1;
		}
		
		System.out.println(DP[N]);
		
//		System.out.println(Arrays.toString(DP));
		
		sc.close();
	}
}
