package day_04.BOJ_G5_9251_Fail;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		int N = str1.length();
		int M = str2.length();
		
		int[][] matrix = new int[N][M];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(str1.charAt(i)==str2.charAt(j)) matrix[i][j]++;
			}
		}
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		int[][] DP = new int[1+N][1+M];
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=M ; j++) {
				DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]) + matrix[i-1][j-1];
			}
		}
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=M ; j++) {
				System.out.print(DP[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(DP[N][M]);
		
	}
}
