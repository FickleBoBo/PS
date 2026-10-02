package day_12.BOJ_G5_1240;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] adj;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		
		adj = new int[1+N][1+N];
		
		for(int i=0 ; i<N-1 ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int v = sc.nextInt();
			adj[x][y] = adj[y][x] = v;
		}
		
		for(int i=0 ; i<M ; i++) {
			visited = new boolean[1+N];
			ans = 0;
			DFS(sc.nextInt(), sc.nextInt(), 0);
			System.out.println(ans);
		}
		
		sc.close();
	}

	private static void DFS(int a, int b, int v) {
		if(visited[a]) return;
		if(a==b) {
			ans = v;
			return;
		}
		
		for(int i=1 ; i<=N ; i++) {
			if(!visited[i] && adj[a][i]>0) {
				visited[a] = true;
				DFS(i, b, v+adj[a][i]);
			}
		}
	}
	
}
