package day_04.BOJ_G2_19238;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	// 문제에서 입력으로 들어오는 변수
	static int N;                      // 주어진 맵의 크기(인덱스가 1부터 시작하니 패딩하면 BFS에서 범위 체크할 때도 편안)
	static int M;                      // 승객의 수
	static long fuel;                  // 연료의 양(혹시 몰라서 long으로 함) -> int로 해도 통과됨
	static int[][] map;                // 그냥 맵
	static int[] taxi_pos;             // 택시의 위치를 나타낸 배열 [2][1]
	static int[][] passenger_pos;      // 승객의 현재 위치와 목적지를 한번에 나타낸 배열 [M][4]
	
	// 편의를 위해 만든 변수
	static int[] dr = {-1, 0, 1, 0};    // 상 우 하 좌 델타배열
	static int[] dc = {0, 1, 0, -1};    // 상 우 하 좌 델타배열
	static boolean[][] visited;         // BFS용 방문 체크
	static int[][] dist;                // 택시 -> 승객, 승객 -> 목적지 두 가지 거리를 담음 [M][2]
	
	
	
	public static void main(String[] args) {
		
		/*
		 * step1
		 * 
		 * 쭉 입력 받아주는데 맵의 경우 상하좌우 패딩했으니 처리를 해줘야 함(벽으로 채워줘)
		 */
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		fuel = sc.nextLong();
		
		map = new int[1+N+1][1+N+1];    // <- 상하좌우 채우는거 편하게 안되나??
		for(int i=0 ; i<N+2 ; i++) {
			Arrays.fill(map[i], 1);
		}
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		taxi_pos = new int[] {sc.nextInt(), sc.nextInt()};    // taxi_pos = {sc.nextInt(), sc.nextInt()}; 이건 빨간 줄임
		
		passenger_pos = new int[M][4];
		for(int i=0 ; i<M ; i++) {
			passenger_pos[i][0] = sc.nextInt();    // 승객의 현재 행
			passenger_pos[i][1] = sc.nextInt();    // 승객의 현재 열
			passenger_pos[i][2] = sc.nextInt();    // 목적지의 행
			passenger_pos[i][3] = sc.nextInt();    // 목적지의 열
		}
		
		/*
		 * step2
		 * 
		 * dist는 0번 열에는 택시와 승객과의 거리를 담고, 1번 열에는 승객과 목적지와의 거리를 담는다
		 * 근데 승객과 목적지와의 거리는 항상 일정하므로 따로 계산을 해준다(시간 초과 남)
		 */
		dist = new int[M][2];
		setDistance();    // 승객과 목적지와의 거리 계산
		
		/*
		 * step3
		 * 
		 * 문제 조건 1 - 현재 택시 위치에서 가장 가까운 거리에 있는 승객을 태운다
		 * 문제 조건 2 - 그런 승객이 2명 이상이면 행이 작은 애, 열이 작은 애를 고른다
		 * 문제 조건 3 - 택시와 승객이 같은 위치에 서 있으면 승객과의 거리는 0이다 <- BFS가 이거를 놓쳐서 디버깅 오래 걸림
		 * 문제 조건 4 - 모든 승객을 못 태울 경우 -1 출력
		 */
		int cnt = M;    // 남은 승객 수
		while(cnt > 0) {
			
			calDistance();    // 택시의 현재 위치는 계속 변하니 다시 구해줘야 한다
			
			// 모든 승객과의 거리를 비교해서 가장 가까우면서 행과 열번호가 작은 승객을 찾음 <- 이거 구현이 은근 까다롭게 느껴짐
			int min = Integer.MAX_VALUE;
			int minIdx = -1;    // 승객의 번호와 같다고 볼 수 있는 숫자로 갱신이 안됐으면 배열에 넣었을 때 에러나서 낫뱃한듯
			for(int i=0 ; i<M ; i++) {
				if(dist[i][0] >= 0) {
					if(min > dist[i][0]) {
						min = dist[i][0];
						minIdx = i;
					}
					else if(min!=Integer.MAX_VALUE && min==dist[i][0]) {
						if(passenger_pos[i][0] < passenger_pos[minIdx][0]) {
							minIdx = i;
						}
						else if(passenger_pos[i][0] == passenger_pos[minIdx][0]) {
							if(passenger_pos[i][1] < passenger_pos[minIdx][1]) {
								minIdx = i;
							}
						}
					}
				}
			}
			
			// 이거 없으면 10% 구간에서 인덱스 에러나는데 이유를 잘은 모르겠음. 아마 while문 안에 순서 바꾸면 없어도 될거 같기도?
			if(minIdx==-1) break;
			
			// 골랐으면 연료를 택시와 승객거리, 승객과 목적지거리 만큼 빼주는데 1씩 빼줄 필요가 없음(중간에 택시가 멈추는거나 도착지에 음수 연료로 오나 같은거임)
			fuel -= (dist[minIdx][0] + dist[minIdx][1]);
			
			
			if(fuel < 0) {
				break;
			}
			else {
				fuel += dist[minIdx][1]*2;                 // 승객과 목적지 거리만큼 연료 충전
				dist[minIdx][0] = Integer.MAX_VALUE;       // 승객을 날랐으면 승객과 목적지 거리를 무한대로 만들어서 줌
				taxi_pos[0] = passenger_pos[minIdx][2];    // 택시 위치 갱신
				taxi_pos[1] = passenger_pos[minIdx][3];    // 택시 위치 갱신
			}
			
			cnt--;
			
		}

		/*
		 * step4
		 * 
		 * 이제 출력만 해주면 되는데 연료가 바닥났다==승객이 남았다 이라서 cnt만 갖고 비교하면 됨
		 */
		if(cnt > 0) System.out.println(-1);
		else System.out.println(fuel);
		
		sc.close();
	}
	
	

	// 현재 택시 위치에서 승객까지의 최단 거리를 세팅
	private static void calDistance() {
		for(int i=0 ; i<M ; i++) {
			if(dist[i][0] != Integer.MAX_VALUE) {    // 무한대가 이미 날른 승객이라는 말이라서 저 위치는 갱신하면 안됨(약간 방문체크)
				dist[i][0] = BFS(taxi_pos[0], taxi_pos[1], passenger_pos[i][0], passenger_pos[i][1]);
			}
		}
	}
	
	// 승객의 현재 위치에서 목적지까지의 최단 거리를 세팅 <- 딱 한번만 호출할 메서드
	private static void setDistance() {
		for(int i=0 ; i<M ; i++) {
			dist[i][1] = BFS(passenger_pos[i][0], passenger_pos[i][1], passenger_pos[i][2], passenger_pos[i][3]);
		}
	}

	// (r1, c1)와 (r2, c2)의 최단 거리 반환하는 BFS
	private static int BFS(int r1, int c1, int r2, int c2) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[1+N+1][1+N+1];    // 방문체크 배열을 여기서 만들어야 함
		q.offer(new int[] {r1, c1});
		visited[r1][c1] = true;
		int ans = 0;    // 두 점 사이의 최단 거리
		
		if(r1==r2 && c1==c2) {    // 이게 문제 조건 3 적용한거
			return ans;
		}
		
		while(!q.isEmpty()) {
			ans++;
			int len = q.size();    // 아래 for문에 바로 q.size() 넣으면 안됨
			
			for(int i=0 ; i<len ; i++) {    // 블로그보다가 최단거리를 이렇게 찾는거 봤는데 좋아보여서 써봄
				int[] item = q.poll();
				for(int dir=0 ; dir<4 ; dir++) {
					int nr = item[0] + dr[dir];
					int nc = item[1] + dc[dir];
					
					if(nr==r2 && nc==c2) {    // 목적지 찾으면 리턴
						return ans;
					}
					
					if(map[nr][nc]==0 && !visited[nr][nc]) {    // 목적지 아니면 큐에 넣고 방문 체크
						q.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}

		}
		
		// while문을 빠져나왔다는건 벽으로 막혀서 못가는 목적지인거와 같은 말
		return Integer.MAX_VALUE;
	}
	
}
