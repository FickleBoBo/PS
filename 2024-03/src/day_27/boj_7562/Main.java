package day_27.BOJ_S1_7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int [] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int [] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			int N = sc.nextInt();
			boolean[][] map = new boolean[N][N];
			
			int[] curPos = {sc.nextInt(), sc.nextInt()};
			int[] desPos = {sc.nextInt(), sc.nextInt()};
			int move = 0;
			int cnt = 0;
			
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(curPos);
			map[curPos[0]][curPos[1]] = true;
			cnt = q.size();
			
			while(!q.isEmpty()) {
				int[] nextPos = q.poll();
				cnt--;
				
				if((nextPos[0]==desPos[0]) && ((nextPos[1]==desPos[1]))) {
					break;
				}
				
				for(int dir=0 ; dir<8 ; dir++) {
					int nr = nextPos[0] + dr[dir];
					int nc = nextPos[1] + dc[dir];
					if((nr>=0) && (nc>=0) && (nr<N) && (nc<N) && (!map[nr][nc])) {
						q.offer(new int[] {nr, nc});
						map[nr][nc] = true;
					}
				}
				
				if(cnt == 0) {
					cnt = q.size();
					move++;
				}
			}
			
			System.out.println(move);
			
		}
		
		sc.close();
	}
}
