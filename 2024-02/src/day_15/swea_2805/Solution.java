package day_15.SWEA_D3_2805;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());        // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {                  // tc : 각각의 테스트 케이스
			
			int N = Integer.parseInt(sc.nextLine());    // N : 농장의 크기(버퍼땜에 이렇게 받자)
			String[][] tmpArr = new String[N][N];       // tmpArr : input값 임시 저장 배열
			int[][] farm = new int[N][N];               // farm : 농장 데이터를 int로 저장
			
			// String[][]를 int[][]로 바꿔주는 작업
			for(int i=0 ; i<N ; i++) {
				tmpArr[i] = sc.nextLine().split("");
				for(int j=0 ; j<N ; j++) {
					farm[i][j] = Integer.parseInt(tmpArr[i][j]);
				}
			}
			
			int left = N / 2;                         // left : 왼쪽 시작점 표시
			int right = N / 2;                        // right : 오른쪽 끝점 표시
			int ans = 0;                              // ans : 수확량의 총합
			for(int i=0 ; i<N ; i++) {                // 농장에 대해 행순회
				for(int j=left ; j<=right ; j++) {    // 시작과 끝은 지정한 범위까지만
					ans += farm[i][j];                // 무지성 덧셈
				}
				if(i<N/2) {                           // 중간 넘어오기 전까지는 범위가 점점 넓어짐
					left--; right++;
				}
				else {                                // 중간 넘어가면 범위를 다시 좁힘
					left++; right--;
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
