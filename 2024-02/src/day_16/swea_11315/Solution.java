package day_16.SWEA_D3_11315;

import java.util.Scanner;

public class Solution {
	
	static boolean check(String[][] arr) {
		int N = arr.length;
		
		// 가로 방향 오목 여부 탐색
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N-4 ; j++) {
				if(arr[i][j].equals("o") && 
						(arr[i][j+1].equals("o")) && 
						(arr[i][j+2].equals("o")) && 
						(arr[i][j+3].equals("o")) && 
						(arr[i][j+4].equals("o"))) {
					return true;
				}
			}
		}
		
		// 세로 방향 오목 여부 탐색
		for(int i=0 ; i<N-4 ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j].equals("o") && 
						(arr[i+1][j].equals("o")) && 
						(arr[i+2][j].equals("o")) && 
						(arr[i+3][j].equals("o")) && 
						(arr[i+4][j].equals("o"))) {
					return true;
				}
			}
		}
		
		// 좌상우하 방향 오목 여부 탐색
		for(int i=0 ; i<N-4 ; i++) {
			for(int j=0 ; j<N-4 ; j++) {
				if(arr[i][j].equals("o") && 
						(arr[i+1][j+1].equals("o")) && 
						(arr[i+2][j+2].equals("o")) && 
						(arr[i+3][j+3].equals("o")) && 
						(arr[i+4][j+4].equals("o"))) {
					return true;
				}
			}
		}
		
		// 우상좌하 방향 오목 여부 탐색
		for(int i=0 ; i<N-4 ; i++) {
			for(int j=4 ; j<N ; j++) {
				if(arr[i][j].equals("o") && 
						(arr[i+1][j-1].equals("o")) && 
						(arr[i+2][j-2].equals("o")) && 
						(arr[i+3][j-3].equals("o")) && 
						(arr[i+4][j-4].equals("o"))) {
					return true;
				}
			}
		}
		
		// 전부 오목이 아니면 false 반환
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();             // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {    // tc : 각각의 테스트 케이스
			
			int N = sc.nextInt();                   // N : 오목판의 크기
			String[][] table = new String[N][N];    // table : 오목판 생성
			for(int i=0 ; i<N ; i++) {
				table[i] = sc.next().split("");
			}
			
			boolean Omok = check(table);    // 오목 달성 여부 반환 받아서 저장
			if(Omok) System.out.printf("#%d YES\n", tc);
			else     System.out.printf("#%d NO\n", tc);
		}
		
		sc.close();
	}
}
