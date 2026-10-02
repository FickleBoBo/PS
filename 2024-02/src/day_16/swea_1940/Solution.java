package day_16.SWEA_D2_1940;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();    // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {    // tc : 각각의 테스트 케이스
			int N = sc.nextInt();         // N : 명령 갯수
			int vel = 0;                  // vel : 현재 속도
			int dist = 0;                 // dist : 이동 거리
			for(int i=0 ; i<N ; i++) {
				int command = sc.nextInt();    // command : 어떤 명령인지 입력
				if(command==1) {               // 가속일 경우
					vel += sc.nextInt();       // 속도 더해줌
				}
				else if(command==2) {                        // 감속일 경우
					vel = Math.max(vel-=sc.nextInt(), 0);    // 속도를 빼주는데 음수가 되지 않게
				}
				dist += vel;    // 가속, 감속, 현재속도 유지 이후 이동거리 갱신
			}
			System.out.printf("#%d %d\n", tc, dist);
		}
		sc.close();
	}
}
