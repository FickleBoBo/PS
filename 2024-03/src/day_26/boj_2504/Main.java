package day_26.BOJ_G5_2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] strInput = str.split("");
		char[] input = str.toCharArray();
		
		Stack<Character> tmp = new Stack<Character>();
		boolean flag = false;
		for(int i=0 ; i<input.length ; i++) {
			if((input[i]=='(') || (input[i]=='[')) {
				tmp.push(input[i]);
			}
			else {
				if(tmp.isEmpty()) {
					flag = true;
					break;
				}
				else {
					if(input[i]==')') {
						if(tmp.peek()=='(') {
							tmp.pop();
						}
						else {
							flag = true;
							break;
						}
					}
					else {
						if(tmp.peek()=='[') {
							tmp.pop();
						}
						else {
							flag = true;
							break;
						}
					}
				}
			}
		}
		if(!tmp.isEmpty()) flag = true;
		
		if(flag) {
			System.out.println(0);
		}
		else {
			Stack<String> st = new Stack<>();
			for(int i=0 ; i<strInput.length ; i++) {
				
				if((strInput[i].equals("(")) || (strInput[i].equals("["))) {
					st.push(strInput[i]);
				}
				else {
					if(strInput[i].equals(")")) {
						if(st.peek().equals("(")) {
							st.pop();
							st.push("2");
						}
						else {
							int n = Integer.parseInt(st.pop());
							st.pop();
							st.push((n*2)+"");
						}
					}
					else {
						if(st.peek().equals("[")) {
							st.pop();
							st.push("3");
						}
						else {
							int n = Integer.parseInt(st.pop());
							st.pop();
							st.push((n*3)+"");
						}
					}
				}
				
				if(st.size() >= 2) {
					String last = st.pop();
					String last_1 = st.pop();
					if(!(last.equals("(")) && !(last.equals("[")) && !(last_1.equals("(")) && !(last_1.equals("["))){
						int n = Integer.parseInt(last_1) + Integer.parseInt(last);
						st.push(n+"");
					}
					else {
						st.push(last_1);
						st.push(last);
					}
				}
				
			}
			
			while(!st.isEmpty()) {
				System.out.println(st.pop());
			}
				
		}
		
		sc.close();
	}
}
