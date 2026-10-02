package day_25.BOJ_G5_7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0, 0, 0};    // 상 우 하 좌 위 아래
	static int[] dc = {0, 1, 0, -1, 0, 0};    // 상 우 하 좌 위 아래
	static int[] dh = {0, 0, 0, 0, -1, 1};    // 상 우 하 좌 위 아래
	static int M;
	static int N;
	static int H;
	static int tomatoNum;
	static int emptyNum;
	static int[][][] tomatoBoxes;
	static boolean[][][] visited;
	static int ans = -1;
	
	public static void main(String[] args) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		tomatoNum = 0;
		emptyNum = 0;
		tomatoBoxes = new int[N][M][H];
		visited = new boolean[N][M][H];
		for(int k=0 ; k<H ; k++) {
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<M ; j++) {
					tomatoBoxes[i][j][k] = sc.nextInt();
					if(tomatoBoxes[i][j][k] == 1) {
						q.offer(new int[] {i, j, k});
						tomatoNum++;
					}
					else if(tomatoBoxes[i][j][k] == -1) {
						emptyNum++;
					}
				}
			}
		}
		
		if(tomatoNum != N*M*H-emptyNum) {
			int size = q.size();
			while(!q.isEmpty()) {
				int[] item = q.poll();
				visited[item[0]][item[1]][item[2]] = true;
				size--;
				
				for(int dir=0 ; dir<6 ; dir++) {
					int nr = item[0] + dr[dir];
					int nc = item[1] + dc[dir];
					int nh = item[2] + dh[dir];
					if((nr>=0)&&(nc>=0)&&(nh>=0)&&(nr<N)&&(nc<M)&&(nh<H)&&(tomatoBoxes[nr][nc][nh]==0)&&(!visited[nr][nc][nh])) {
						q.offer(new int[] {nr, nc, nh});
						tomatoBoxes[nr][nc][nh] = 1;
						tomatoNum++;
					}
				}
				
				if(size == 0) {
					ans++;
					size = q.size();
				}
			}
			
			if(tomatoNum != N*M*H-emptyNum) System.out.println(-1);
			else System.out.println(ans);
		}
		else {
			System.out.println(0);
		}
		
		sc.close();
		
	}

}
