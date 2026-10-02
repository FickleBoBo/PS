package day_30.SWEA_D2_1204;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();                // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {       // tc : 각 테스트 케이스마다 반복
			
			int n = sc.nextInt();            // n : 그냥 넘버링
			int[] count = new int[101];      // count : 바로 카운팅 배열 만들기
			for(int i=0 ; i<1000 ; i++) {
				count[sc.nextInt()]++;       // 입력 받은 값을 바로 count 배열에 넣기
			}
			
			int max = maxIdx(count);         // 최빈값을 찾는 메소드로 리턴 받기
			
			System.out.printf("#%d %d\n", n, max);
			
			sc.close();
		}
	}
	
	public static int maxIdx(int[] arr) {      // 카운팅 배열은 max값이 최빈값인게 포인트~!!
		int max = Integer.MIN_VALUE;           // 수업에서 배운 테크닉
		int maxIdx = 0;                        // maxIdx : 인덱스용 변수
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] >= max) {
				max = arr[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}
	
}
