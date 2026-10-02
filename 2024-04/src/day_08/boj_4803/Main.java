package day_08.BOJ_G4_4803;

import java.util.Scanner;

public class Main {
	
	static int[] p;                // 유니온 파인드에서 부모 저장 배열
	static int[] edgeCnt;          // 간선의 개수를 담은 배열(그룹장에게 몰빵함)
	static boolean[][] visited;    // 방문 체크
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = 1;    // 출력 양식 맞추기
		
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			if(n==0 && m==0) break;    // 종료 조건

			// 기본 세팅
			p = new int[1+n];
			for(int i=1 ; i<=n ; i++) {
				p[i] = i;
			}
			edgeCnt = new int[1+n];
			visited = new boolean[1+n][1+n];
			
			for(int i=0 ; i<m ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
//				if(x==y) continue;    // 같은거 오면 안되나 했는데 필요 없었음
//				if(!visited[x][y]) {    // 1 -> 2 랑 2 -> 1을 받았을 때 트리로 해야하는 줄 알았는데 그런 입력은 없었던 듯
//					visited[x][y] = visited[y][x] = true;
//					union(find(x), find(y));
//				}
				union(find(x), find(y));
			}
			
			int[] countingArr = new int[1+n];    // 그룹장에게 몇 개 노드 붙어있나 세는 배열
			for(int i=1 ; i<=n ; i++) {
				countingArr[find(p[i])]++;    // 이거에서 디버깅 오래 걸렸는데 한번 더 find로 이어줘야 했음(추가된 코드)
			}
			
			for(int i=1 ; i<=n ; i++) {
				p[i] = find(p[i]);    // 모든 노드 돌면서 패스 컴프레션 다시 해줌(그룹장에게 전부 붙어있는 꼴로 만들고 싶어서)
				if(countingArr[i]==0 && edgeCnt[i]!=0) {    // 그룹장이 아닌데 간선이 붙어있는 걸로 나오는 애가 있으면 간선을 그룹장에 붙여줌(없으면 틀림)
					edgeCnt[p[i]] += edgeCnt[i];
					edgeCnt[i] = 0;
				}
			}
			
//			System.out.println(Arrays.toString(p));
//			System.out.println(Arrays.toString(edgeCnt));
//			System.out.println(Arrays.toString(countingArr));
			
			int ans = 0;
			for(int i=1 ; i<=n ; i++) {
				if(p[i]==i && edgeCnt[i]==countingArr[i]-1) {    // 그룹장이면서 간선이 노드보다 1개 적으면(==트리)
					ans++;
				}
			}
			
			if(ans > 1) System.out.printf("Case %d: A forest of %d trees.\n", tc++, ans);
			else if(ans == 1) System.out.printf("Case %d: There is one tree.\n", tc++);
			else System.out.printf("Case %d: No trees.\n", tc++);
			
		}
		sc.close();
	}

	// test에도 있는데 이렇게 짜야되는듯
	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

	// 유니온하면서 간선을 세줘야 함(패스 컴프레션 때문에 간선이 씹힘)
	private static void union(int x, int y) {
		p[y] = x;
		edgeCnt[x]++;
	}
	
}
