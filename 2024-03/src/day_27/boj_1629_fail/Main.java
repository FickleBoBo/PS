package day_27.BOJ_S1_1629_Fail;

import java.util.Scanner;

public class Main {
	
	static long c;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextInt();
		long B = sc.nextInt();
		c = sc.nextInt();
		
		System.out.println(function(A, B) % c);
		
		sc.close();
	}

	private static long function(long a, long b) {
		// 종료 조건
		if(b==1) return a;
		
		// 재귀 조건
		if (b % 2 == 1) {
			return (long) Math.pow(function(a, b/2), 2) % c * a;
		}
		else {
			return (long) Math.pow(function(a, b/2), 2) % c;
		}
		
	}
}
