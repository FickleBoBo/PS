package day_15.BOJ_G4_16398;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] adj = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				adj[i][j] = sc.nextInt();
			}
		}
		
		boolean[] visited = new boolean[N];
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[0] = 0;
		for(int i=0 ; i<N ; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j=0 ; j<N ; j++) {
				if(!visited[j] && dist[j]<min) {
					min = dist[j];
					idx = j;
				}
			}
			
			visited[idx] = true;
			
			for(int j=0 ; j<N ; j++) {
				if(!visited[j] && adj[idx][j]<dist[j] && adj[idx][j]>0) {
					dist[j] = adj[idx][j];
				}
			}
		}
		
		long ans = 0;
		for(int i=0 ; i<N ; i++) {
			ans += dist[i];
		}

		System.out.println(ans);
		sc.close();
	}
}
