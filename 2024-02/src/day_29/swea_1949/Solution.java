package day_29.SWEA_모의SW역량테스트_1949;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static int[] dr = {-1, 0, 1, 0};    // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1};    // 상 우 하 좌
	static int[][] map;    // map : 원본 맵
	static int[][] copyMap;    // copyMap : 원본 맵을 복사한 맵
	static int N;    // N : 맵의 크기(가로, 세로)
	static int K;    // K : 최대 지형 깎기
	static int ans;    // ans : 최종 출력할 정답
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();    // T : 테스트 케이스의 수
		
		for(int tc=1 ; tc<=T ; tc++) {    // 각각의 테스트 케이스

			// step1 - 입력 받아 초기화 하기
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			for(int i=0 ; i<N ; i++) {
				for (int j=0 ; j<N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ans = 0;

			// 2. 가능한 모든 길 찾기
			for(int n=0 ; n<=K ; n++){
				findPath(n);
			}

			// 3. 정답 출력
			System.out.printf("#%d %d\n", tc, ans);
			
		}
		sc.close();
	}

	// copyMap에 map을 복사하는 메서드
	static void copyOriginMap(){
		copyMap = new int[N][N];
		for(int i=0 ; i<N ; i++) {
			copyMap[i] = Arrays.copyOf(map[i], N);
		}
	}

	// 원본 map의 봉우리의 개수 리턴
	static int findOriginPeaks() {
		int peak = Integer.MIN_VALUE;

		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(map[i][j] > peak) {    // 더 높은 지형을 발견하면
					peak = map[i][j];    // 봉우리 높이 갱신
				}
			}
		}

		int cnt = 0;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(map[i][j] == peak) {
					cnt++;
				}
			}
		}
//		System.out.println(cnt);
		return cnt;
	}

	// copyMap에서 봉우리들을 찾는 메서드
	static Stack<int[]> findPeaks(int row, int col, int dig) {
		int tmpPeak = Integer.MIN_VALUE;    // tmpPeak : 임시 봉우리 변수
		Stack<int[]> st = new Stack<int[]>();    // 봉우리들을 담을 스택

		copyOriginMap();    // 원본 map을 새롭게 복사해주기
		copyMap[row][col] -= dig;    // 지형 깎기
//		if(copyMap[row][col] < 0){    // 지형은 0 이상 정수다!로 했는데도 1개가 통과안됨
//			return st;
//		}

		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(copyMap[i][j] > tmpPeak) {    // 더 높은 지형을 발견하면
					st.clear();    // 지금까지 담은게 봉우리가 아니니까 스택을 비워줘야겠지
					tmpPeak = copyMap[i][j];    // 봉우리 높이 갱신
					st.push(new int[] {i, j});    // 스택에 푸시
				}
				else if(copyMap[i][j] == tmpPeak) {    // 같은 높이의 봉우리를 발견하면
					st.push(new int[] {i, j});    // 거기도 스택에 푸시
				}
			}
		}

		if(findOriginPeaks()==1 && st.size()==2){    // 봉우리부터 깎지는 못한다 추가해도 안되네;; 진짜뭐임
			st.clear();
//			System.out.println(st.size());
//			return st;
		}

		return st;    // 봉우리들의 좌표를 담은 스택 리턴
	}


	
	static void findPath(int dig) {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				Stack<int[]> st = findPeaks(i, j, dig);    // 복사한 맵의 모든 좌표에서 dig만큼 깍았을 때 봉우리들을 받음
				
				while(!st.isEmpty()) {    // 스택의 모든 원소에 대해 좌표를 받아 pathFinding() 메서드에 넘겨줌
					int startRow = st.peek()[0];
					int startCol = st.peek()[1];
					st.pop();
					
					pathFinding(startRow, startCol, 1);
				}
			}
		}
	}
	
	static void pathFinding(int r, int c, int len) {
		for(int dir=0 ; dir<4 ; dir++) {    // 사방탐색
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if((nr==-1) || (nc==-1) || (nr==N) || (nc==N)){
				continue;
			}
			
			if((copyMap[nr][nc] < copyMap[r][c])) {    // 새로운 좌표가 맵의 안쪽이면서 낮은 지형이면
				pathFinding(nr, nc, len+1);    // 등산로 길이 늘리면서 사방탐색 재귀
			}
		}
		if(len > ans) {
			ans = len;
		}
	}

}
