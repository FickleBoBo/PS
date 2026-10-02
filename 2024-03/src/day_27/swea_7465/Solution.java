package day_27.SWEA_D4_7465;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N;          // 사람 수
	static int[][] adj;    // 인접 행렬
	static int ans;        // 정답
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			ans = 0;
			N = sc.nextInt();
			int M = sc.nextInt();
			adj = new int[N+1][N+1];       // 사람은 1번 부터라 패딩
			for(int i=1 ; i<=N ; i++) {    // 혼자인 사람은 입력에 안들어와서 자기자신과 무리임을 표시해야 함!!!!!!
				adj[i][i] = 1;
			}
			
			for(int i=0 ; i<M ; i++) {    // 연결 관계 입력 받기
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				adj[p1][p2] = adj[p2][p1] = 1;    // 인접 행렬 채워주기
			}
			
			for(int i=1 ; i<=N ; i++) {    // 인접 행렬에서 BFS 돌기
				for(int j=1 ; j<=N ; j++) {
					if(adj[i][j] == 1) {
						BFS(i, j);
						ans++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, ans);
			
		}
		
		sc.close();
	}
	
	// 인접 행렬 상 연결된 곳 전부 0으로 바꾸고 종료
	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		for(int i=1 ; i<=N ; i++) {    // 입력으로 들어온 좌표와 같은 행은 전부 큐에 넣어줌
			if(adj[r][i]==1) {
				q.offer(new int[] {r, i});
				adj[r][i] = 0;
				adj[i][r] = 0;
			}
		}

		// 인접한 사람들을 다 찾을 때까지 반복
		while(!q.isEmpty()) {
			int connect = q.poll()[1];
			for(int i=1 ; i<=N ; i++) {
				if(adj[connect][i] == 1) {
					q.offer(new int[] {connect, i});
					adj[connect][i] = 0;
					adj[i][connect] = 0;
				}
			}
		}
	}

}
