package day_02.SWEA_D4_7465;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static int[] p;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			p = new int[1+N];
			for(int i=1 ; i<=N ; i++) {
				p[i] = i;
			}
			
			for(int i=0 ; i<M ; i++) {
				int x = findSet(sc.nextInt());
				int y = findSet(sc.nextInt());
				union(x, y);
			}
			
			Set<Integer> set = new HashSet<Integer>();
			
			for(int i=1 ; i<=N ; i++) {
				set.add(findSet(i));
			}
			
			System.out.printf("#%d %d\n", tc, set.size());
			
		}
		sc.close();
	}
	
	private static int findSet(int x) {
		if(p[x]==x) return x;
		return findSet(p[x]);
	}
	
	private static void union(int x, int y) {
		p[y] = x;
	}
	
}
