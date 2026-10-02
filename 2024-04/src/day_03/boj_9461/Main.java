package day_03.BOJ_S3_9461;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			
			switch (N) {
			case 1: {
				System.out.println(1);
				break;
			}
			case 2: {
				System.out.println(1);
				break;
			}
			case 3: {
				System.out.println(1);
				break;
			}
			case 4: {
				System.out.println(2);
				break;
			}
			case 5: {
				System.out.println(2);
				break;
			}
			default:
				long[] DP = new long[1+N];
				DP[1] = 1;
				DP[2] = 1;
				DP[3] = 1;
				DP[4] = 2;
				DP[5] = 2;
				for(int i=6 ; i<=N ; i++) {
					DP[i] = DP[i-1] + DP[i-5];
				}
				
				System.out.println(DP[N]);
			}
		}
		
		sc.close();
		
	}
}
