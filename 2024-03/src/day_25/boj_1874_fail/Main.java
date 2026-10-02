package day_25.BOJ_S2_1874_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n+1];
		for(int i=1 ; i<=n ; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Queue<Character> q = new LinkedList<>();
		
		Stack<Integer> st1 = new Stack<Integer>();
		Stack<Integer> st2 = new Stack<Integer>();
		
//		for(int i=1 ; i<=n ; i++) {
//			if(nums[i] == i) {
//				q.offer('+');
//				st1.push(i);
//			}
//			else if(nums[i] )
//			
//			
//			
//		}
		
	}
}
