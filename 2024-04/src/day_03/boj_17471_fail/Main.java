package day_03.BOJ_G4_17471_Fail;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] population;
	static int[] p;
	static int[] cntArr;
	static int ans = -1;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		population = new int[1+N];
		int[][] adj = new int[1+N][1+N];
		p = new int[1+N];
		cntArr = new int[1+N];
		
		for(int i=1 ; i<=N ; i++) {
			population[i] = sc.nextInt();
		}
		
		for(int i=1 ; i<=N ; i++) {
			int n = sc.nextInt();
			for(int j=1 ; j<=n ; j++) {
				int x = sc.nextInt();
				adj[i][x]++;
			}
		}
		
		for(int i=1 ; i<=N ; i++) {
			p[i] = i;
		}
		
		
		
		
		
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=i ; j<=N ; j++) {
				if(adj[i][j] != 0) {
					int x = find(i);
					int y = find(j);
					union(x, y);
				}
			}
		}
		
		if(count() == 2) {
			int n1 = -1;
			int n2 = -1;
			for(int i=1 ; i<=N ; i++) {
				if(cntArr[i] != 0) {
					n1 = cntArr[i];
					break;
				}
			}
			for(int i=N ; i>=1; i--) {
				if(cntArr[i] != 0) {
					n2 = cntArr[i];
					break;
				}
			}
			ans = Math.min(ans, Math.abs(n1-n2));
		}
		else if(count() == 1) {
			
		}
		
		
		
		
		
		
		
		sc.close();
	}
	
	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return x;
	}
	
	private static void union(int x, int y) {
		p[y] = x;
	}
	
	private static int count() {
		int cnt = 0;
		for(int i=1 ; i<=N ; i++) {
			cntArr[find(i)] += population[i];
		}
		for(int i=1 ; i<=N ; i++) {
			if(cntArr[i]!=0) cnt++;
		}
		
		return cnt;
	}
	
}
