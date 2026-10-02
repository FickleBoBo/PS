package day_04.BOJ_G5_2096;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<3 ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 편하게 좌우 패딩해줌(기본 값이 0이라 최댓값에서는 꿀)
		int[][] DP = new int[1+N][1+3+1];
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=3 ; j++) {
				DP[i][j] = Math.max(DP[i-1][j-1], Math.max(DP[i-1][j], DP[i-1][j+1])) + map[i-1][j-1];
			}
		}
		
		System.out.print(Math.max(DP[N][1], Math.max(DP[N][2], DP[N][3])) + " ");
		
		// 패딩을 정수 최댓값으로 해야 경계 효과 생김
		for(int i=0 ; i<=N ; i++) {
			DP[i][0] = DP[i][4] = Integer.MAX_VALUE;
		}
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=3 ; j++) {
				DP[i][j] = Math.min(DP[i-1][j-1], Math.min(DP[i-1][j], DP[i-1][j+1])) + map[i-1][j-1];
			}
		}
		
		System.out.println(Math.min(DP[N][1], Math.min(DP[N][2], DP[N][3])));
		
		sc.close();
	}
}
