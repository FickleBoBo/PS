package day_29.BOJ_G5_10026;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N;
	static char[][] map;
	static boolean[][] visited1;
	static boolean[][] visited2;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.nextLine());
		map = new char[N][N];
		for(int i=0 ; i<N ; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		int ans1 = 0;
		int ans2 = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(!visited1[i][j]) {
					BFS1(i, j);
					ans1++;
				}
				if(!visited2[i][j]) {
					BFS2(i, j);
					ans2++;
				}
			}
		}
		
		System.out.println(ans1 + " " + ans2);
		sc.close();
	}

	private static void BFS1(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		visited1[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] item = q.poll();
			for(int dir=0 ; dir<4 ; dir++) {
				int nr = item[0] + dr[dir];
				int nc = item[1] + dc[dir];
				if((nr>=0) && (nc>=0) && (nr<N) && (nc<N) && (!visited1[nr][nc]) && (map[nr][nc]==map[r][c])) {
					q.offer(new int[] {nr, nc});
					visited1[nr][nc] = true;
				}
			}
		}
	}
	
	private static void BFS2(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		visited2[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] item = q.poll();
			for(int dir=0 ; dir<4 ; dir++) {
				int nr = item[0] + dr[dir];
				int nc = item[1] + dc[dir];
				if((nr>=0) && (nc>=0) && (nr<N) && (nc<N) && (!visited2[nr][nc])) {
					if(map[nr][nc]=='B') {
						if(map[r][c]=='B') {
							q.offer(new int[] {nr, nc});
							visited2[nr][nc] = true;
						}
					}
					else {
						if(map[r][c]!='B') {
							q.offer(new int[] {nr, nc});
							visited2[nr][nc] = true;
						}
					}
				}
			}
		}
	}
}
