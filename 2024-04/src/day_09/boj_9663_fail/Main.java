package day_09.BOJ_G4_9663_Fail;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int ans = 0;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new boolean[N][N];
		
		for(int i=0 ; i<N ; i++) {
			DFS(i);
		}
		
		sc.close();
	}

	private static void DFS(int r) {
		if(r==N) {
			return;
		}
		
		for(int i=0 ; i<N ; i++) {
			if(!visited[r][i]) {
				DFS(i+1);
			}
		}
		

		
	}
	
}
