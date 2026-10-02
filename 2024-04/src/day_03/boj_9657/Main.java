package day_03.BOJ_S3_9657;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N==1) System.out.println("SK");
		else if(N==2) System.out.println("CY");
		else if(N==3) System.out.println("SK");
		else if(N==4) System.out.println("SK");
		else {
			int[] DP = new int[1+N];
			DP[1] = 1;
			DP[2] = 2;
			DP[3] = 1;
			DP[4] = 1;
			for(int i=5 ; i<=N ; i++) {
				DP[i] = DP[i-4]%2==0 ? DP[i-4]+1 : Math.max(DP[i-1], DP[i-3])+1;
			}
			if(DP[N] % 2 == 1) System.out.println("SK");
			else System.out.println("CY");
		}
		sc.close();
	}
}
