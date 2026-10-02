package day_29.SWEA_D3_4698;

import java.util.Scanner;

public class Solution {
	
	static int[] primeArr = new int[168];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int i = 0;
		for(int num=2 ; num<=1000 ; num++) {
			boolean isPrime = true;
			for(int n=2 ; n<=Math.sqrt(num) ; n++) {
				if(num % n == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				primeArr[i++] = num;
			}
		}
		
		for(int tc=1 ; tc<=T ; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int ans = 0;
			
			for(int num=A ; num<=B ; num++) {
				boolean isPrime = true;
				for(int n=0 ; n<168 ; n++) {
//					if(num <= primeArr[n]) {
//						break;
//					}
					if(num % primeArr[n] == 0) {
						isPrime = false;
						break;
					}
				}
				
				if(isPrime) {
					boolean primeHasD = false;
					int q = num / 10;
					int r = num % 10;
					if(r == D) {
						ans++;
						primeHasD = true;
					}
					while((!primeHasD) && (q > 0)) {
						r = q % 10;
						q = q / 10;
						if(r == D) {
							ans++;
							primeHasD = true;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}
