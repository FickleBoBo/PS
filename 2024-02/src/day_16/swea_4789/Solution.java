package day_16.SWEA_D3_4789;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();    // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {    // tc : 각각의 테스트 케이스
			
			String[] tmp = sc.next().split("");                   // tmp : 일단 String 배열로 받아줌
			int[] audience = new int[tmp.length];                 // audience : 관객 정보를 배열로 저장할 예정
			int[] audiencePrefix = new int[audience.length+1];    // audiencePrefix : 관객 정보 누적합
			
			int ans = 0;    // ans : 고용할 인원 수
			for(int i=0 ; i<tmp.length ; i++) {
				audience[i] = Integer.parseInt(tmp[i]);                   // 자료형 바꿔줌
				audiencePrefix[i+1] = audiencePrefix[i] + audience[i];    // 누적합 계산해줌
				ans = Math.max(ans, i+1-audiencePrefix[i+1]);             // 인덱스와 누적합의 차이로 고용인원 계산 가능
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
