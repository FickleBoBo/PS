package day_30.SWEA_D3_1220;

import java.util.Scanner;

public class Solution {
	
	static int[][] table = new int[100][100];    // 테이블 크기 100 X 100 으로 고정이라 이렇게 설정함
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {    // tc : 테스트 케이스의 수(10번 고정)
			
			int T = sc.nextInt();          // T : 테이블 한변의 길이(사실상 입력 받는 의미는 없음)
			int cnt = 0;                   // cnt : 교착 상태의 개수 세기
			for(int i=0 ; i<100 ; i++) {
				for(int j=0 ; j<100 ; j++)
					table[i][j] = sc.nextInt();    // 2차원 배열에 입력 받기
			}
			
			for(int j=0 ; j<100 ; j++) {         // 열 우선 순회로 할거라 j로 놓은게 포인트
				int flag = 1;                    // flag : N극, S극을 찾는 역할(N : 1 / S : 2)
				int tmpCnt = 0;                  // tmpCnt : cnt에 넣기전 데이터 가공용 임시 변수
				for(int i=0 ; i<100 ; i++)
					if(table[i][j] == flag) {    // flag를 찾으면(= 원하는 N극 or S극을 찾으면)
						flag = 3 - flag;         // flag를 변경(1->2 / 2->1 로 바꿔주는 식)
						tmpCnt++;
					}
				cnt += tmpCnt / 2;               // 이게 포인트인데 교착 상태가 아닌데 카운드된 상황을 나눗셈때문에 버림이 되어서 알맞게 값이 들어감
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
		sc.close();    // 이제 무지성으로 넣으라 해서 넣음
	}
}
