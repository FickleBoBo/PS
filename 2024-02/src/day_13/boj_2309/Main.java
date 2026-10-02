package day_13.BOJ_B1_2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] height = new int[9];    // height : 9명의 키를 담을 배열
		int total = 0;                // total : 9명의 키를 모두 더한다
		for(int i=0 ; i<9 ; i++) {
			height[i] = sc.nextInt();
			total += height[i];
		}
		
		out:
		for(int i=0 ; i<8 ; i++) {
			for(int j=i+1 ; j<9 ; j++) {     // 중복 피하기 + 경우의 수 최소화
				int sum = height[i] + height[j];
				if ((total - sum)==100) {    // 9명 키 더하고 2명 키를 빼서 구하자
					height[i] = 0;
					height[j] = 0;
					break out;
				}
			}
		}
		
		Arrays.sort(height);    // 범인은 키가 0으로 바뀌었으니 3번째부터 출력하면됨
		
		for(int i=2 ; i<9 ; i++) {
			System.out.println(height[i]);
		}
		
	}
}
