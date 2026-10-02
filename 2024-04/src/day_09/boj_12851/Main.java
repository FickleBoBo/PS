package day_09.BOJ_G4_12851;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int ans = 0;
	static int cnt = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		DFS(N, K);
		
		System.out.println(ans);
		System.out.println(cnt);
		
		sc.close();
	}
	
	private static void DFS(int n, int k) {
		boolean flag = false;
		Queue<Integer> q = new LinkedList<>();
		int[] dp = new int[200_001];
		q.offer(n);
		
		if(n==k) {
			cnt=1;
			return;    // 이거가 75% 장벽
		}
		
//		System.out.print("      ");
//		for(int p=0 ; p<50 ; p++) {
//			System.out.printf("%3d ", p);
//		}
		
		while(!flag) {
			int len = q.size();
			
			for(int i=0 ; i<len ; i++) {
				int pos = q.poll();

				if(pos*2<=200000 && ((dp[pos*2]==0) || (dp[pos*2]!=0 && dp[pos*2]>ans))) {
					if(pos*2 == k) {
						cnt++;
						flag = true;
					}
					else {
						dp[pos*2] = ans+1;
						q.offer(pos*2);
					}
				}
				if(pos-1>=0 && ((dp[pos-1]==0) || (dp[pos-1]!=0 && dp[pos-1]>ans))) {
					if(pos-1 == k) {
						cnt++;
						flag = true;
					}
					else {
						dp[pos-1] = ans+1;
						q.offer(pos-1);
					}
				}
				if(pos+1<=100000 && ((dp[pos+1]==0) || (dp[pos+1]!=0 && dp[pos+1]>ans))) {
					if(pos+1 == k) {
						cnt++;
						flag = true;
					}
					else {
						dp[pos+1] = ans+1;
						q.offer(pos+1);
					}
				}
				
				
//				System.out.printf("%3d : ", pos);
//				for(int p=0 ; p<50 ; p++) {
//					System.out.printf("%3d ", dp[p]);
//				}
//				System.out.println();
				
				
				
			}
			

			
			ans++;
		}
		
	}
}
