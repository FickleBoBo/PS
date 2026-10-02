package day_16.SWEA_D2_1979;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();                   // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {          // tc : 각각의 테스트 케이스
			int N = sc.nextInt();               // N : 퍼즐판의 크기
			int K = sc.nextInt();               // K : 특정 단어의 길이
			int[][] arr = new int[N+1][N+1];    // arr : 퍼즐판에 오른쪽 아랫쪽 패딩 줌(벽으로 초기화 됨)
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					arr[i][j] = sc.nextInt();    // 퍼즐판 입력 받아서 채우기
				}
			}
			
			int ans = 0;    // ans : 정답값
			
			// 가로 방향 탐색
			// 뚫린 곳을 찾으면 오른쪽으로 뚫린 칸을 전부 세서 K칸이면 ans에 +1
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N-K+1 ; j++) {
					if(arr[i][j]==1) {
						int cnt = 1;
						while(arr[i][++j]==1) {
							cnt++;
						}
						if(cnt==K) {
							ans++;
						}
					}
				}
			}
			
			// 세로 방향 탐색
			// 뚫린 곳을 찾으면 아랫쪽으로 뚫린 칸을 전부 세서 K칸이면 ans에 +1
			for(int j=0 ; j<N ; j++) {
				for(int i=0 ; i<N-K+1 ; i++) {
					if(arr[i][j]==1) {
						int cnt = 1;
						while(arr[++i][j]==1) {
							cnt++;
						}
						if(cnt==K) {
							ans++;
						}
					}
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
			
		}
		sc.close();
	}
}
