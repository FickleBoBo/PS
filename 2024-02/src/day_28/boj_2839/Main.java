package day_28.BOJ_S4_2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int ans = -1;                        // ans : 설탕 봉지 조합을 못찾으면 -1 이므로 미리 초기화
		out:
		for(int i=N/5 ; i>=0 ; i--) {        // N/5 부터 -1씩하는건 5kg 봉지를 최대한 써본다는 느낌
			for(int j=0 ; j<=N/3 ; j++) {    // N/3을 전부 돌려보면서 조합이 되나 확인
				if(5 * i+3 * j == N) {       // 딱 맞으면
					ans = i + j;             // 봉지수 더하고
					break out;               // 이중 반복문 완전 탈출해야 값이 덮어씌워지지 않음
				}
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
