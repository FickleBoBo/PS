package day_16.SWEA_D3_6190;

import java.util.Scanner;

public class Solution {
	
	/* 단조 증가인지 확인할 메서드
	 * 주어진 숫자에 대해 10으로 나눈 몫과 나머지1을 구하고 몫을 10으로 나눈 나머지2를 구한다
	 * 나머지1이 나머지2보다 크거나 같아야 단조 증가
	 * 중복 계산이 들어가서 좀 더 다듬어야 할 듯
	 * */
	static boolean isMonotoneIncreasingNum(int n) {
		
		int num = n;
		while(num > 0) {
			int remain = num % 10;
			num /= 10;
			int remain2 = num % 10;
			if(remain < remain2) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();             // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {    // tc : 각각의 테스트 케이스
			
			int max = -1;                 // max : 단조 증가하는 수를 못 찾으면 -1 출력하려고
			int N = sc.nextInt();         // N : 주어질 정수 수열의 수
			int[] arr = new int[N];       // arr : 정수 배열
			
			for(int i=0 ; i<N ; i++) {
				arr[i] = sc.nextInt();    // 일단 입력 받아서 배열에 저장해 줌
			}
			
			for(int i=0 ; i<N-1 ; i++) {
				for(int j=i+1 ; j<N ; j++) {              // j의 시작 위치 중요함
					int num = arr[i] * arr[j];            // num : 단조 증가일지 확인할 수
					if(isMonotoneIncreasingNum(num)) {    // 단조 증가한다면
						max = Math.max(max, num);         // max값 갱신
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
			
		}
		
		sc.close();
		
	}
}
