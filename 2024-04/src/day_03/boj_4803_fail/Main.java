package day_03.BOJ_G4_4803_Fail;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] p;
	static int[] cntArr;
	static int cnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			if(N==0 && M==0) break;
			
			p = new int[1+N];
			for(int i=1 ; i<=N ; i++) {
				p[i] = i;
			}
			
			for(int i=0 ; i<M ; i++) {
				int x = find(sc.nextInt());
				int y = find(sc.nextInt());
				union(x, y);
			}
			
			cntArr = new int[1+N];
			
			int ans = count();
			
			if(ans > 1) System.out.printf("A forest of %d trees\n", ans);
			else if(ans == 1) System.out.println("There is one tree");
			else System.out.println("No trees");

			
			System.out.println(Arrays.toString(p));
			System.out.println(Arrays.toString(cntArr));
			
		}
		sc.close();
	}

	
	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	private static void union(int x, int y) {
		if(p[y]==x) cnt++;
		p[y] = x;
	}
	
	private static int count() {
		for(int i=1 ; i<=N ; i++) {
			cntArr[find(i)]++;
		}
		
		int cnt = 0;
		
		for(int i=1 ; i<=N ; i++) {
			if(cntArr[i]!=0 && find(i)==i) {
				cnt++;
			}
		}
		return cnt;
	}

}
