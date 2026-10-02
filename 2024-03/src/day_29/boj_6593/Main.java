package day_29.BOJ_G5_6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] dl = {0, 0, 0, 0, -1, 1};    // 북 동 남 서 상 하
	static int[] dr = {-1, 0, 1, 0, 0, 0};    // 북 동 남 서 상 하
	static int[] dc = {0, 1, 0, -1, 0, 0};    // 북 동 남 서 상 하
	static int L;
	static int R;
	static int C;
	static char[][][] map;
	static int[] start;
	static int[] end;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] input = br.readLine().split(" ");
			L = Integer.parseInt(input[0]);
			R = Integer.parseInt(input[1]);
			C = Integer.parseInt(input[2]);
			
			if(L==0) break;
			
			StringBuilder sb = new StringBuilder();
			for(int i=0 ; i<L*R+L ; i++) {
				sb.append(br.readLine());
			}
			
			map = new char[L+2][R+2][C+2];
			int idx = 0;
			for(int i=1 ; i<=L ; i++) {
				for(int j=1 ; j<=R ; j++) {
					for(int k=1 ; k<=C ; k++) {
						map[i][j][k] = sb.charAt(idx++);
						if(map[i][j][k]=='S') {
							start = new int[]{i, j, k};
						}
						else if(map[i][j][k]=='E') {
							end = new int[]{i, j, k};
						}
					}
				}
			}
			
			ans = 1;
			boolean escape = BFS();
			if(escape) System.out.printf("Escaped in %d minute(s).\n", ans);
			else System.out.println("Trapped!");
		}
		br.close();
	}

	private static boolean BFS() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(start);
		map[start[0]][start[1]][start[2]] = '#';
		int cnt = q.size();
		
		while(!q.isEmpty()) {
			int[] item = q.poll();
			cnt--;
			
			for(int dir=0 ; dir<6 ; dir++) {
				int nl = item[0] + dl[dir];
				int nr = item[1] + dr[dir];
				int nc = item[2] + dc[dir];
				if(map[nl][nr][nc]=='E') return true;
				if(map[nl][nr][nc]=='.') {
					q.offer(new int[] {nl, nr, nc});
					map[nl][nr][nc] = '#';
				}
			}
			
			if(cnt==0) {
				ans++;
				cnt = q.size();
			}
			
		}
		return false;
	}
}
