package day_06.SWEA_D3_8931;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();                // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int N = sc.nextInt();            // N : 향후 등장할 정수의 수
			Stack st = new Stack(N);         // st : 스택질할 스택
			
			for(int i=0 ; i<N ; i++) {
				int money = sc.nextInt();    // money : 지출 금액
				if(money > 0) {              // 지출 금액이 있으면 푸시
					st.push(money);
				}
				else {                       // 잘못 불렀으면 팝
					st.pop();
				}
			}
			System.out.printf("#%d %d\n", tc, st.sum());
		}
		sc.close();
	}
}

class Stack{
	
	// 멤버 변수
	int len = 0;
	int arr[] = new int[len];
	int top = -1;
	
	// 생성자
	public Stack() {}
	
	public Stack(int len) {
		this();
		this.len = len;
		this.arr = new int[len];
	}
	
	// 멤버 메서드
	public void push(int n) {
		arr[++top] = n;
	}
	
	public int pop() {
		return arr[top--];
	}
	
	// 스택의 총합을 알려주는 sum() 메서드
	public int sum() {
		int sum = 0;
		for(int i=0 ; i<=top ; i++) {
			sum += arr[i];
		}
		return sum;
	}
}