package day_31.SWEA_D3_1209;

import java.util.Scanner;
import java.util.Stack;

public class Solution{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<Integer>();   // stack : 최댓값만 담을 스택 선언
		int[][] arr = new int[100][100];               // arr : 2차원 배열 담을 예정
		
		for(int tc=1 ; tc<=10 ; tc++) {                // tc : 테스트 케이스의 수(10으로 고정)
			
			sc.nextInt();                              // 테스트 케이스 번호 흡수용(nextLine 쓰면 안됨~!!!!)
			for(int i=0 ; i<100 ; i++) {
				for(int j=0 ; j<100 ; j++) {
					arr[i][j] = sc.nextInt();          // 일단 담자
				}
			}
			stack.push(Integer.MIN_VALUE);             // 더미용 값 하나 푸시
			
			
			
			for(int i=0 ; i<100 ; i++) {
				int sum1 = 0;                          // sum1 : 각 행의 총합
				int sum2 = 0;                          // sum2 : 각 열의 총합
				for(int j=0 ; j<100 ; j++) {
					sum1 += arr[i][j];                 // 행 우선 순회
					sum2 += arr[j][i];                 // 열 우선 순회
				}
				int max1 = sum1>sum2 ? sum1 : sum2;    // max : 둘 중 최댓값 저장
				if(max1>stack.peek()) {                // stack의 최댓값보다 크면 pop하고 푸시
					stack.pop();                       // (stack은 항상 하나의 값만 갖음)
					stack.push(max1);
				}
			}
			
			int sum3 = 0;                              // sum3 : 좌상에서 우하로 가는 대각선의 합
			int sum4 = 0;                              // sum4 : 우상에서 좌하로 가는 대각선의 합
			for(int i=0 ; i<100 ; i++){
				sum3 += arr[i][i];
				sum4 += arr[i][99-i];
			}
			int max2 = sum3>sum4 ? sum3 : sum4;
			if(max2>stack.peek()) {
				stack.pop();
				stack.push(max2);
			}
			
			System.out.printf("#%d %d\n", tc, stack.pop());    // pop하면서 stack을 비워줌
			
		}
		sc.close();
	}
}