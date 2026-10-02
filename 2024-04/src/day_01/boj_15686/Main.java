package day_01.BOJ_G5_15686;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static List<int[]> homePos;
	static List<int[]> chickenPos;
	static int[] sel;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		homePos = new ArrayList<int[]>();
		chickenPos = new ArrayList<int[]>();
		
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=N ; j++) {
				int n = sc.nextInt();
				if(n==1) homePos.add(new int[] {i, j});
				else if(n==2) chickenPos.add(new int[] {i, j});
			}
		}
		sel = new int[M];
		
		combination(0, 0);
		
		System.out.println(ans);
		
		
//		for(int[] arr : homePos) {
//			System.out.println(Arrays.toString(arr));
//		}
//		System.out.println();
//		for(int[] arr : chickenPos) {
//			System.out.println(Arrays.toString(arr));
//		}
//		
//		System.out.println(chickenDist());
		
		
		
		sc.close();
	}
	
	private static void combination(int idx, int sidx) {
		if(sidx==M) {
//			System.out.println(Arrays.toString(sel));
			ans = Math.min(ans, chickenDist(sel));
			return;
		}
		
		for(int i=idx ; i<chickenPos.size() ; i++) {
			sel[sidx] = i;
			combination(i+1, sidx+1);
		}
	}

	private static int chickenDist(int[] select) {
		int ans = 0;
		
		for(int i=0 ; i<homePos.size() ; i++) {
			int dist = Integer.MAX_VALUE;
			
			for(int j : select) {
				int len = Math.abs(homePos.get(i)[0]-chickenPos.get(j)[0])+Math.abs(homePos.get(i)[1]-chickenPos.get(j)[1]);
				dist = Math.min(dist, len);
			}
			
			ans += dist;
		}
		return ans;
	}
	
}
