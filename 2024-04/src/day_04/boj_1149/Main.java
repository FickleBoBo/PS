package day_04.BOJ_S1_1149;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		for(int i=0 ; i<N ; i++) {
			for (int j=0 ; j<3 ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 바로 위에서만 안 내려오면 됨
		int[][] DP = new int[1+N][3];
		for(int i=1 ; i<=N ; i++) {
			DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + map[i-1][0];
			DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + map[i-1][1];
			DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + map[i-1][2];
		}
		
		System.out.println(Math.min(DP[N][0], Math.min(DP[N][1], DP[N][2])));
		
		sc.close();
	}
}
