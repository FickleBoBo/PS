package day_01.BOJ_S3_1021_Fail;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Queue<Integer> input = new LinkedList<Integer>();
		for(int i=0 ; i<M ; i++) {
			input.offer(sc.nextInt());
		}
		
		List<Integer> list = new LinkedList<Integer>();
		for(int i=1 ; i<=N ; i++) {
			list.add(i);
		}
		
		int ans = 0;
		while(list.size() != N-M) {
			int a = -1;
			int b = -1;
			
			for(int i=0 ; i<list.size() ; i++) {
				if(list.get(i)==input.peek()) {
					a = i;
					break;
				}
			}
			
			for(int i=list.size()-1 ; i>=0 ; i--) {
				if(list.get(i)==input.peek()) {
					b = list.size()-i-1;
					break;
				}
			}
			
			if(a==0) {
				list.remove(0);
				input.poll();
			}
			else if(a<b) {
				ans += a;
				for(int i=0 ; i<a ; i++) {
					list.add(list.get(0));
					list.remove(0);
				}
			}
			else if(a>b) {
				ans += b;
				for(int i=0 ; i<b ; i++) {
					list.add(0, list.get(list.size()-1));
					list.remove(list.size()-1);
				}
			}
			
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
