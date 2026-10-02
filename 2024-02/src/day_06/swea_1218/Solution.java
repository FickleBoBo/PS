package day_06.SWEA_D4_1218;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1 ; tc<=10 ; tc++) {
			
			int flag = 1;    // flag : 하나라도 안맞으면 바로 0으로 바꿔버리기
			int len = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();
			Stack st1 = new Stack(str.length());    // () 받을 스택
			Stack st2 = new Stack(str.length());    // {} 받을 스택
			Stack st3 = new Stack(str.length());    // [] 받을 스택
			Stack st4 = new Stack(str.length());    // <> 받을 스택
			
			// str 돌면서 열린 괄호 시리즈면 푸시, 닫힌 괄호 시리즈면 팝
			// 팝하기 전에 스택이 비어있는지 확인해서 비어있으면 flag 바꾸고 반복문 종료
			for(int i=0 ; i<str.length() ; i++) {
				if(str.charAt(i)=='(') {
					st1.push('(');
				}
				else if(str.charAt(i)==')') {
					if(st1.isEmpty()) {
						flag = 0;
						break;
					}
					else {
						st1.pop();
					}
				}
				else if(str.charAt(i)=='{') {
					st2.push('{');
				}
				else if(str.charAt(i)=='}') {
					if(st2.isEmpty()) {
						flag = 0;
						break;
					}
					else {
						st2.pop();
					}
				}
				else if(str.charAt(i)=='[') {
					st3.push('[');
				}
				else if(str.charAt(i)==']') {
					if(st3.isEmpty()) {
						flag = 0;
						break;
					}
					else {
						st3.pop();
					}
				}
				else if(str.charAt(i)=='<') {
					st4.push('<');
				}
				else if(str.charAt(i)=='>') {
					if(st4.isEmpty()) {
						flag = 0;
						break;
					}
					else {
						st4.pop();
					}
				}
			}
			
			// 스택에 열린 괄호가 남아있어도 flag가 0으로 바뀌어야 함
			if(st1.isEmpty() && st2.isEmpty() && st3.isEmpty() && st4.isEmpty()) {
				// clear
			}
			else {
				flag = 0;
			}
			System.out.printf("#%d %d\n", tc, flag);
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
	public Stack() {}
	
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
	
	public boolean isEmpty() {
		return top == -1;
	}
	
}