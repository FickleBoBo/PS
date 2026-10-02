package day_27.SWEA_D3_5215;

import java.util.Scanner;

public class Solution {	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();    // T : 테스트 케이스의 수
		
		// 각 테스트 케이스마다 기본 세팅 입력 받기
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int limit = sc.nextInt();
			int[] points = new int[N];
			int[] calories = new int[N];
			for(int i=0 ; i<N ; i++) {
				points[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			int ans = 0;
			
			// 비트마스크 on
			for(int i=0 ; i < (1<<N) ; i++) {
				int tmpAns = 0;        // 임시 정답
				int limitCheck = 0;    // 각 케이스마다 상한값 더해놓음
				for(int j=0 ; j<N ; j++) {
					if(((1<<j) & i) > 0) {
						if(limitCheck + calories[N-j-1] > limit) {    // 넘어가면 더 계산말고 break
							break;
						}
						tmpAns += points[N-j-1];
						limitCheck += calories[N-j-1];
					}
				}
				ans = ans > tmpAns ? ans : tmpAns;    // 무탈하면 기존의 최댓값과 비교
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
