package day_04.BOJ_S2_11048;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][M];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 얻을 수 있는 사탕 개수의 최대는 현재 위치 기준 위쪽, 왼쪽, 위왼쪽?까지 얻을 수 있었던 사탕의 수에 현재 칸 더한거
		int[][] DP = new int[1+N][1+M];
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=M ; j++) {
				DP[i][j] = Math.max(DP[i-1][j-1], Math.max(DP[i-1][j], DP[i][j-1])) + map[i-1][j-1];
			}
		}
		
		System.out.println(DP[N][M]);
		
		sc.close();
	}
}
