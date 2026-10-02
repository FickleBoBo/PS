package day_11.BOJ_G3_17471_Fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] sel;
	static int[] nums;
	static int[][] adj;
	static int ans = -1;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		nums = new int[1+N];
		for(int i=1 ; i<=N ; i++) {
			nums[i] = sc.nextInt();
		}
		
		adj = new int[1+N][1+N];
		for(int i=1 ; i<=N ; i++) {
			int len = sc.nextInt();
			for(int j=0 ; j<len ; j++) {
				adj[i][sc.nextInt()]++;
			}
		}
		
		for(int i=1 ; i<N ; i++) {
			sel = new int[i];
			combination(0, 0, i);
		}
		
		System.out.println(ans);
		
		sc.close();
	}

	private static void combination(int idx, int sidx, int len) {
		if(sidx==len) {
			int[] left = new int[N-len];
			int idx1 = 0;
			int idx2 = 0;
			out:
			for(int i=1 ; i<=N ; i++) {
				if(sel[idx1] != i) {
					left[idx2++] = i;
				}
				else {
					idx1++;
					if(idx1==len) {
						int tmp = 1;
						for(int j=idx2 ; j<N-len ; j++) {
							left[j] = sel[len-1] + tmp++;
						}
						break out;
					}
				}
			}
			
//			System.out.println(Arrays.toString(sel));

			System.out.println(Arrays.toString(sel));
			System.out.println(BFS(sel));
			System.out.println(Arrays.toString(left));
			System.out.println(BFS(left));
			
			if(BFS(sel) && BFS(left)) {
				int sum1 = 0;
				int sum2 = 0;
				for(int i=0 ; i<sel.length ; i++) {
					sum1 += nums[sel[i]];
				}
				for(int i=0 ; i<left.length ; i++) {
					sum2 += nums[left[i]];
				}
				int diff = Math.abs(sum1 - sum2);
				if(ans < 0) {
					ans = diff;
				}
				else {
					ans = Math.min(ans, diff);
				}
			}
			
			return;
		}
		
		for(int i=idx ; i<N ; i++) {
			sel[sidx] = i+1;
			combination(i+1, sidx+1, len);
		}
	}

	private static boolean BFS(int[] arr) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[1+N];
		q.offer(arr[0]);
		visited[arr[0]] = true;
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int item = q.poll();
			for(int i=1 ; i<=N ; i++) {
				if(!visited[i] && adj[item][i]==1 && Arrays.asList(arr).contains(i)) {
					q.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		
//		System.out.println(Arrays.toString(visited));
		
//		for(int i=0 ; i<arr.length ; i++) {
//			if(!visited[arr[i]]) {
//				return false;
//			}
//		}
		
		if(cnt != arr.length) {
			return false;
		}
		
		return true;
	}
	
}
