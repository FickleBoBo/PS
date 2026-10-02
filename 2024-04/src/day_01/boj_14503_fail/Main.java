package day_01.BOJ_G5_14503_Fail;

import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};    // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1};    // 상 우 하 좌
	static int N;
	static int M;
	static int[][] map;
	static boolean flag = false;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		map = new int[N][M];
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int ans = 0;
		DFS(r, c, d);
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(map[i][j]==2) ans++;
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}
	
	private static void DFS(int r, int c, int d) {
		// 종료 조건
		if(flag) return;
		if((r<0) || (c<0) || (r==N) || (c==M) || (map[r][c]!=0)) {
			return;
		}
		
		// 동작
		if(map[r][c]==0) {
			map[r][c] = 2;
		}
		
		printMap();
		
		// 재귀 조건
		for(int dir=0 ; dir<4 ; dir++) {
			int nr = r + dr[(d+dir-1+4)%4];
			int nc = c + dc[(d+dir-1+4)%4];
			if((nr>=0) && (nc>=0) && (nr<N) && (nc<M) && (map[nr][nc]==0)) {
				System.out.println("방향 : " + (d+dir-1+4)%4);
				DFS(nr, nc, (d+dir-1+4)%4);
			}
		}
		flag = true;
	}

	private static void printMap() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
