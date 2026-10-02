package day_05.SWEA_D3_2806;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static int N;
	static int[] sel;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			N = sc.nextInt();
			sel = new int[N];
			visited = new boolean[N];
			ans = 0;
			combination(0);
			System.out.printf("#%d %d\n", tc, ans);
		}
		
		sc.close();
	}

	private static void combination(int sidx) {
		if(sidx==N) {
			if(checkDiagoanl()) {
				ans++;
			}
			return;
		}
		
		for(int i=0 ; i<N ; i++) {
			if(!visited[i]) {
				sel[sidx] = i;
				visited[i] = true;
				combination(sidx+1);
				visited[i] = false;
			}

		}
		
	}

	private static boolean checkDiagoanl() {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		
		for(int i=0 ; i<N ; i++) {
			set1.add(i+sel[i]);
			set2.add(i-sel[i]);
		}
		
		if(set1.size()==N && set2.size()==N) return true;
		return false;
	}
}
