package day_04.SWEA_D2_1970;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int[] DP = new int[8];
			int N = sc.nextInt();
			DP[0] = N % 50 / 10;
			DP[1] = N / 50;

			for(int i=2 ; i<8 ; i++) {
				if(i%2==0) {
					DP[i] = DP[i-1] / 2;
					DP[i-1] %= 2;
				}
				else {
					DP[i] = DP[i-1] / 5;
					DP[i-1] %= 5;
				}
			}
			
			System.out.println("#" + tc);
			for(int i=7 ; i>=0 ; i--) {
				System.out.print(DP[i] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
