package day_17.BOJ_G2_1368;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int ans = 0;    // 모든 논에 우물을 파는 비용을 들고 시작하려고 미리 ans 선언
		
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();    // V : 논의 수
		
		int[] W = new int[V];    // W : 각각의 논에 우물을 파는데 드는 비용
		for(int i=0 ; i<V ; i++) {
			W[i] = sc.nextInt();
			ans += W[i];
		}
		
		int[][] adj = new int[V*(V-1)/2][3];    // 논 사이에 물을 끌어오는 인접 행렬을 받을 간선 배열
		int idx = 0;
		for(int i=0 ; i<V ; i++) {
			for(int j=0 ; j<V ; j++) {
				int w = sc.nextInt();
				if(i < j) {    // 무방향이라 대칭되는 반대는 씹어줌(메모리도 작음)
					adj[idx][0] = i;
					adj[idx][1] = j;
					adj[idx][2] = w;
					idx++;
				}
			}
		}
		Arrays.sort(adj, (o1, o2) -> {    // 정렬 까먹어서 디버깅 좀 걸림
			return o1[2] - o2[2];
		});
		
		// 크루스칼로 구할 예정
		p = new int[V];
		for(int i=0 ; i<V ; i++) {
			p[i] = i;
		}

		int cnt = 0;
		for(int i=0 ; i<adj.length ; i++) {
			int x = find(adj[i][0]);
			int y = find(adj[i][1]);
			if(x != y) {
				/* 여기가 중요한데 이어진 그래프에서 우물을 파는 논은 하나면 되고 
				 * 가장 비용이 작은 논이어야 함
				 * 그러면 union을 하는 과정에서 그룹장을 가장 비용이 작은 논이 되게 작업을 해줘야 함
				 */
				if(W[x] < W[y]) union(x, y);
				else union(y, x);
				cnt++;
				/* 여기도 중요한데 최소 비용은 모든 논에 각자 우물을 파는 경우부터 최소 신장 트리가 되는 경우 사이에 있음
				 * 모든 논에 각자 우물을 파는 경우의 비용은 처음에 ans에 저장했고, 
				 * 다른 논에서 물을 끌어올 경우 기존의 ans에서 우물을 팠던 비용을 빼고 물을 끌어온 비용을 더해서 최솟값을 찾는 과정을 반복
				 */
				ans = Math.min(ans, ans-Math.max(W[x], W[y])+adj[i][2]);
				if(cnt == V-1) break;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
	
	private static int[] p;
	
	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	private static void union(int x, int y) {
		p[y] = x;
	}
	
}
