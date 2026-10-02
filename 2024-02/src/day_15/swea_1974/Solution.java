package day_15.SWEA_D2_1974;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();                  // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {         // tc : 각각의 테스트 케이스
			int[][] sudoku = new int[9][9];    // sudoku : 스도쿠 숫자를 받을 2차원 배열
			for(int i=0 ; i<9 ; i++) {
				for(int j=0 ; j<9 ; j++) {
					sudoku[i][j] = sc.nextInt();    // 9*9개 숫자 받아서 저장
				}
			}
			
			boolean isOK = sudokuVerification(sudoku);    // 스도쿠가 적절하면 true를 리턴하는 메소드
			
			if(isOK) System.out.printf("#%d 1\n", tc);    // 스도쿠가 적절하면 1 출력
			else System.out.printf("#%d 0\n", tc);        // 스도쿠가 부적절하면 0 출력
		}
		sc.close();
	}
	
	// 스도쿠를 검증하는 메소드로 일단 적절하다고 가정 후 반례가 있으면 바로 false 리턴하고 종료
	static boolean sudokuVerification(int[][] arr) {
		
		// 가로 행 탐색
		for(int i=0 ; i<9 ; i++) {
			int[] cnt = new int[1+9];    // 카운팅 배열을 만들어 전부 1이면 적절!!
			
			for(int j=0 ; j<9 ; j++) {
				cnt[arr[i][j]]++;
			}
			for(int k=1 ; k<=9 ; k++) {
				if(cnt[k] != 1) {
					return false;
				}
			}
		}
		
		// 세로 열 탐색
		for(int j=0 ; j<9 ; j++) {
			int[] cnt = new int[1+9];    // 카운팅 배열을 만들어 전부 1이면 적절!!
			
			for(int i=0 ; i<9 ; i++) {
				cnt[arr[i][j]]++;
			}
			for(int k=1 ; k<=9 ; k++) {
				if(cnt[k] != 1) {
					return false;
				}
			}
		}
		
		// 네모 탐색
		for(int m=0 ; m<7 ; m+=3) {          // 각 네모는 3씩 인덱스가 이동한 위치이므로 증감 조절
			for(int n=0 ; n<7 ; n+=3) {      // 각 네모는 3씩 인덱스가 이동한 위치이므로 증감 조절
				int[] cnt = new int[1+9];    // 카운팅 배열을 만들어 전부 1이면 적절!!
				
				for(int i=m ; i<m+3 ; i++) {
					for(int j=n ; j<n+3 ; j++) {
						cnt[arr[i][j]]++;
					}
				}
				for(int k=1 ; k<=9 ; k++) {
					if(cnt[k] != 1) {
						return false;
					}
				}
			}
		}
		
		return true;    // 모든 조건을 통과하면 true 리턴
		
	}
	
}
