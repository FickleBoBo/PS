package day_28.SWEA_D3_6485;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int N = sc.nextInt();
			int[] busStop = new int[1+5000];    // 패딩해주고 카운팅 배열 생성
			for(int i=0 ; i<N ; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				for(int j=start ; j<=end ; j++) {    // 카운팅 배열 주어진 범위만큼 채워줌
					busStop[j]++;
				}
			}
			
			System.out.printf("#%d ", tc);
			int P = sc.nextInt();
			for(int i=0 ; i<P ; i++) {
				System.out.printf("%d ", busStop[sc.nextInt()]);    // 주어진 정류장에 맞는 카운팅 배열 원소 출력
			}
			System.out.println();
			
		}
		sc.close();
	}
}
