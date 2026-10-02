package day_05.SWEA_D3_1215;

import java.util.Scanner;

public class Solution{
	
	static String[][] arr = new String[8][8];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			
			int n = Integer.parseInt(sc.nextLine());    // n : 회문 길이
			for(int i=0 ; i<8 ; i++) {
				arr[i] = sc.nextLine().split("");       // arr : 회문 담을 배열
			}
			int cnt = 0;    // cnt : 한 글자씩 비교해가며 회문인지 셀 때 사용
			int ans = 0;    // ans : 회문 갯수
			
			// 가로 회문 탐색
			for(int i=0 ; i<8 ; i++) {              // 행은 전부 돈다
				for(int j=0 ; j<=8-n ; j++) {       // 회문 요구 길이 때문에 시작점이 조건이 걸림
					cnt = 0;                        // 여기서 초기화 해줘야 각 케이스마다 새롭게 계산
					for(int k=0 ; k<n/2 ; k++) {    // 길이의 절반이 같으면 회문
						if(!(arr[i][j+k].equals(arr[i][j+n-k-1]))) {
							break;
						}
						cnt++;
						if(cnt == n/2) {
							ans++;
						}
					}
				}
			}
			
			// 세로 회문 탐색
			for(int i=0 ; i<8 ; i++) {              // 열은 전부 돈다
				for(int j=0 ; j<=8-n ; j++) {       // 회문 요구 길이 때문에 시작점이 조건이 걸림
					cnt = 0;                        // 여기서 초기화 해줘야 각 케이스마다 새롭게 계산
					for(int k=0 ; k<n/2 ; k++) {    // 길이의 절반이 같으면 회문
						if(!(arr[j+k][i].equals(arr[j+n-k-1][i]))) {
							break;
						}
						cnt++;
						if(cnt == n/2) {
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