package day_16.SWEA_D3_1289;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());         // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {                   // tc : 각각의 테스트 케이스
			int flag = 1;                                // flag : 0과 1의 변화점을 체크하는 값
			int cnt = 0;                                 // cnt : 바꾼 횟수
			String[] input = sc.nextLine().split("");    // input : 메모리 상태를 1차원 배열로 받음
			
			// 앞에서부터 숫자가 바뀌는 위치 -> 바꿔줘야할 횟수가 됨
			for(int i=0 ; i<input.length ; i++) {
				if(Integer.parseInt(input[i]) == flag) {
					cnt++;
					flag = 1 - flag;    // 0과 1을 왔다갔다하게 만드는 테크닉
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
		sc.close();
	}
}
