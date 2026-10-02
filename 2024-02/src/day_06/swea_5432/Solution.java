package day_06.SWEA_D4_5432;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());    // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String input = sc.nextLine();            // input : 한 줄 입력 받음
			Stack st = new Stack(input.length());    // st : 문자열 길이만큼의 char[] 배열로 스택 구현
			
			int ans = 0;    // 잘린 쇠막대기 수
			
			for(int i=0 ; i<input.length() ; i++) {    // 문자열 쭉 돌면서 찾기
				if(input.charAt(i)=='(') {             // 열린괄호면 스택에 담음
					st.push('(');
				}
				else {
					st.pop();                       // 닫힌 괄호면 하나 팝
					if(input.charAt(i-1)=='(') {    // 레이저라면
						ans += st.length();         // 스택에 있는 수만큼 잘리겠지?
					}
					else {                          // 쇠막대기라면
						ans += 1;                   // 쇠막대기가 끝났다는 뜻으로 잘린 단면은 자른 횟수 + 1이라는 점을 활용
					}	
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}

class Stack{
	
	// 멤버 변수
	int len = 0;
	char[] arr = new char[len];
	int top = -1;
	
	// 생성자
	public Stack(){}
	
	public Stack(int len) {
		this();
		this.len = len;
		this.arr = new char[len];
	}
	
	// 멤버 메서드
	public void push(char c) {
		arr[++top] = c;
	}
	
	public char pop() {
		return arr[top--];
	}
	
	public int length() {
		return top + 1;
	}
	
}